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
import classesInicias.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario , Serializable{

	private static final long serialVersionUID = 71262372865312693L;
	private Funcionario[] repositorioFuncionario;
	private int numeroDeFuncionario;

	private static RepositorioFuncionario instance;


	private RepositorioFuncionario(int tamanho){
		this.repositorioFuncionario = new Funcionario[tamanho];
		this.numeroDeFuncionario = 0 ;
	}

	public static IRepositorioFuncionario getInstance() {

		if (instance == null) {

			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioFuncionario lerDoArquivo() {
		RepositorioFuncionario instanciaLocal = null;

		File in = new File("funcionarios.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioFuncionario) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioFuncionario(100);
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("funcionarios.txt");
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



	public void adicionarFuncionario(Funcionario funcionario){
		if (funcionario != null && this.numeroDeFuncionario < repositorioFuncionario.length) {
			this.repositorioFuncionario[numeroDeFuncionario] = funcionario;
			this.numeroDeFuncionario++;
			this.salvarArquivo();
		}
		if(numeroDeFuncionario == this.repositorioFuncionario.length){
			this.duplicaArrayRepositorio();

		}

	}


	public void removerFuncionario(String cpf){
		int i;
		for(i=0; i< numeroDeFuncionario ; i++){
			if(this.repositorioFuncionario[i].getCpf().equals(cpf)){
				this.repositorioFuncionario[i]= this.repositorioFuncionario[numeroDeFuncionario-1];
				this.repositorioFuncionario[numeroDeFuncionario-1] = null;
				this.numeroDeFuncionario--;
				this.salvarArquivo();
			}	
		}

	}


	public boolean atualizarFuncionario(String cpf , Funcionario funcionario){
		boolean retorno = false;
		int i;
		for(i=0;i <numeroDeFuncionario;i++){
			if(this.repositorioFuncionario[i].getCpf().equals(cpf)){
				this.repositorioFuncionario[i] = funcionario;
				retorno = true;
				this.salvarArquivo();

			}
		}
		return retorno;
	}


	public Funcionario buscarFuncionario(String cpf) {
		int i;
		Funcionario retorno = null;
		for (i = 0; i < numeroDeFuncionario; i++) {
			if (this.repositorioFuncionario[i].getCpf().equals(cpf)) {

				retorno = this.repositorioFuncionario[i];
			}
		}
		return retorno;
	}

	private void duplicaArrayRepositorio() {
		if (this.repositorioFuncionario != null && this.repositorioFuncionario.length > 0) {
			Funcionario [] arrayDuplicado = new Funcionario[this.repositorioFuncionario.length * 2];
			for (int i = 0; i < this.repositorioFuncionario.length; i++) {
				arrayDuplicado[i] = this.repositorioFuncionario[i];
			}
			this.repositorioFuncionario= arrayDuplicado;
		}
	}


	public boolean existeFuncionario(String cpf) {
		boolean r = false;
		int i = this.procurarFuncionario(cpf);
		if(i != numeroDeFuncionario){
			r = true;
		}


		return r;
	}


	private int procurarFuncionario(String cpf) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.numeroDeFuncionario)) {
			if (cpf.equals(this.repositorioFuncionario[i].getCpf())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

	public List<Funcionario> listarFuncionario(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		for(int i = 0 ; i < numeroDeFuncionario;i++) {
			lista.add(repositorioFuncionario[i]);
			this.salvarArquivo();

		}
		return lista;
	}


	public boolean login(String login, String senha) {
	int i;
	boolean retorno = false;
	for (i = 0; i < numeroDeFuncionario; i++) {
		if (this.repositorioFuncionario[i].getLogin().equals(login) && this.repositorioFuncionario[i].getSenha().equals(senha)) {
				retorno = true;
		}
	}
	return retorno;
	}
	
}
