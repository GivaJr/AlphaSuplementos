package repositorios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import classesInicias.Cliente;


public class RepositorioCliente implements IRepositorioCliente, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2094830880933112096L;
	private Cliente[] repositorioCliente;
	private int numeroDeCliente;

	private static RepositorioCliente instance;



	private RepositorioCliente(int tamanho){
		this.repositorioCliente = new Cliente[tamanho];
		this.numeroDeCliente = 0 ;

	}

	public static IRepositorioCliente getInstance() {

		if (instance == null) {

			instance = lerDoArquivo();
		}
		return instance;	

	}

	private static RepositorioCliente lerDoArquivo() {
		RepositorioCliente instanciaLocal = null;

		File in = new File("clientes.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioCliente) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioCliente(100);
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("cliente.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}


	public void adicionarCliente(Cliente cliente){
		if (cliente != null && this.numeroDeCliente < repositorioCliente.length) {
			this.repositorioCliente[numeroDeCliente] = cliente;
			this.numeroDeCliente++;
		}
		if(numeroDeCliente == this.repositorioCliente.length){
			this.duplicaArrayRepositorio();

		}

	}


	public void removerCliente(String cpf){
		int i;
		for(i=0; i< numeroDeCliente ; i++){
			if(this.repositorioCliente[i].getCpf().equals(cpf)){
				this.repositorioCliente[i]= this.repositorioCliente[numeroDeCliente-1];
				this.repositorioCliente[numeroDeCliente-1] = null;
				this.numeroDeCliente--;
			}	
		}

	}


	public boolean atualizarCliente(String cpf , Cliente cliente){
		boolean retorno = false;
		int i;
		for(i=0;i <numeroDeCliente;i++){
			if(this.repositorioCliente[i].getCpf().equals(cpf)){
				this.repositorioCliente[i] = cliente;
				retorno = true;

			}
		}
		return retorno;
	}



	public Cliente buscarCliente(String cpf) {
		int i;
		Cliente retorno = null;
		for (i = 0; i < numeroDeCliente; i++) {
			if (this.repositorioCliente[i].getCpf().equals(cpf)) {

				retorno = this.repositorioCliente[i];
			}
		}
		return retorno;
	}




	private void duplicaArrayRepositorio() {
		if (this.repositorioCliente != null && this.repositorioCliente.length > 0) {
			Cliente [] arrayDuplicado = new Cliente[this.repositorioCliente.length * 2];
			for (int i = 0; i < this.repositorioCliente.length; i++) {
				arrayDuplicado[i] = this.repositorioCliente[i];
			}
			this.repositorioCliente= arrayDuplicado;
		}
	}


	public boolean existeCliente(String cpf) {
		boolean r = false;
		int i = this.procurarCliente(cpf);
		if(i != numeroDeCliente){
			r = true;
		}


		return r;
	}


	private int procurarCliente(String cpf) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.numeroDeCliente)) {
			if (cpf.equals(this.repositorioCliente[i].getCpf())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}



	public List<Cliente> listarCliente(){
		List<Cliente> lista = new ArrayList<Cliente>();
		for(int i = 0 ; i < numeroDeCliente;i++) {
			lista.add(repositorioCliente[i]);

		}
		return lista;
	}


}
