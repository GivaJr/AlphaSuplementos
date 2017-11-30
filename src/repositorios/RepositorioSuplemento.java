package repositorios;

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




}
