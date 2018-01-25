package repositorios;

import java.util.ArrayList;
import java.util.List;
import classesInicias.Suplemento;

public class RepositorioSuplemento {

	private Suplemento[] repositorioSuplemento;
	private int numeroDeSuplemento;



	public RepositorioSuplemento(int tamanho){
		this.repositorioSuplemento = new Suplemento[tamanho];
		this.numeroDeSuplemento = 0 ;


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
