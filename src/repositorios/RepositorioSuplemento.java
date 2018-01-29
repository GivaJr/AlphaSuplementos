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
import classesInicias.Suplemento;

public class RepositorioSuplemento implements IRepositorioSuplemento, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6028250050143058231L;
	private Suplemento[] repositorioSuplemento;
	private int numeroDeSuplemento;

    private static RepositorioSuplemento instance;

	private RepositorioSuplemento(int tamanho){
		this.repositorioSuplemento = new Suplemento[tamanho];
		this.numeroDeSuplemento = 0 ;


	}
	
	
	public static IRepositorioSuplemento getInstance() {
		
		if (instance == null) {

			instance = lerDoArquivo();
		}
		return instance;	

	}
	
	private static RepositorioSuplemento lerDoArquivo() {
		RepositorioSuplemento instanciaLocal = null;

		File in = new File("suplementos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioSuplemento) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioSuplemento(100);
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
		File out = new File("suplementos.dat");
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
	
	
	
	public void adicionarSuplemento(Suplemento suplemento){
		if (suplemento != null && this.numeroDeSuplemento < repositorioSuplemento.length) {
			this.repositorioSuplemento[numeroDeSuplemento] = suplemento;
			this.numeroDeSuplemento++;
		}
		if(numeroDeSuplemento == this.repositorioSuplemento.length){
			this.duplicaArrayRepositorio();

		}

	}




	public void removerSuplemento(String codigo){
		int i;
		for(i=0; i< numeroDeSuplemento ; i++){
			if(this.repositorioSuplemento[i].getCodigo().equals(codigo)){
				this.repositorioSuplemento[i]= this.repositorioSuplemento[numeroDeSuplemento-1];
				this.repositorioSuplemento[numeroDeSuplemento-1] = null;
				this.numeroDeSuplemento--;
			}	
		}

	}


	public boolean atualizarSuplemento(String codigo , Suplemento suplemento){
		boolean retorno = false;
		int i;
		for(i=0;i <numeroDeSuplemento;i++){
			if(this.repositorioSuplemento[i].getCodigo().equals(codigo)){
				this.repositorioSuplemento [i] = suplemento;
				retorno = true;

			}
		}
		return retorno;
	}

	public Suplemento buscarSuplemento(String codigo) {
		int i;
		Suplemento retorno = null;
		for (i = 0; i < numeroDeSuplemento; i++) {
			if (this.repositorioSuplemento[i].getCodigo().equals(codigo)) {

				retorno = this.repositorioSuplemento[i];
			}
		}
		return retorno;
	}


	private void duplicaArrayRepositorio() {
		if (this.repositorioSuplemento!= null && this.repositorioSuplemento.length > 0) {
			Suplemento [] arrayDuplicado = new Suplemento[this.repositorioSuplemento.length * 2];
			for (int i = 0; i < this.repositorioSuplemento.length; i++) {
				arrayDuplicado[i] = this.repositorioSuplemento[i];
			}
			this.repositorioSuplemento= arrayDuplicado;
		}
	}


	public boolean existeSuplemento(String codigo) {
		boolean r = false;
		int i = this.procurarSuplemento(codigo);
		if(i != numeroDeSuplemento){
			r = true;
		}


		return r;
	}


	private int procurarSuplemento(String codigo) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.numeroDeSuplemento)) {
			if (codigo.equals(this.repositorioSuplemento[i].getCodigo())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}



	public List<Suplemento> listarSuplementos(){
		List<Suplemento> lista = new ArrayList<Suplemento>();
		for(int i = 0 ; i < numeroDeSuplemento;i++) {
			lista.add(repositorioSuplemento[i]);

		}
		return lista;
	}
	
	

	
}
