package repositorios;

import classesInicias.Acessorio;


public class RepositorioAcessorio {

	private Acessorio[] repositorioAcessorio;
	private int numeroDeAcessorio;



	public RepositorioAcessorio(int tamanho){
		this.repositorioAcessorio= new Acessorio[tamanho];
		this.numeroDeAcessorio = 0 ;


	}


	public void adicionarAcessorio(Acessorio acessorio){
		if (acessorio != null && this.numeroDeAcessorio < repositorioAcessorio.length) {
			this.repositorioAcessorio[numeroDeAcessorio] = acessorio;
			this.numeroDeAcessorio++;
		}
		if(numeroDeAcessorio == this.repositorioAcessorio.length){
			this.duplicaArrayRepositorio();

		}

	}



	public void removerAcessorio(String codigo){
		int i;
		for(i=0; i< numeroDeAcessorio ; i++){
			if(this.repositorioAcessorio[i].getCodigo().equals(codigo)){
				this.repositorioAcessorio[i]= this.repositorioAcessorio[numeroDeAcessorio-1];
				this.repositorioAcessorio[numeroDeAcessorio-1] = null;
				this.numeroDeAcessorio--;
			}	
		}

	}


	public boolean atualizarProduto(String codigo , Acessorio acessorio){
		boolean retorno = false;
		int i;
		for(i=0;i <numeroDeAcessorio;i++){
			if(this.repositorioAcessorio[i].getCodigo().equals(codigo)){
				this.repositorioAcessorio[i] = acessorio;
				retorno = true;

			}
		}
		return retorno;
	}


	public Acessorio buscarAcessorio(String codigo) {
		int i;
		Acessorio retorno = null;
		for (i = 0; i < numeroDeAcessorio; i++) {
			if (this.repositorioAcessorio[i].getCodigo().equals(codigo)) {

				retorno = this.repositorioAcessorio[i];
			}
		}
		return retorno;
	}


	private void duplicaArrayRepositorio() {
		if (this.repositorioAcessorio != null && this.repositorioAcessorio.length > 0) {
			Acessorio [] arrayDuplicado = new Acessorio[this.repositorioAcessorio.length * 2];
			for (int i = 0; i < this.repositorioAcessorio.length; i++) {
				arrayDuplicado[i] = this.repositorioAcessorio[i];
			}
			this.repositorioAcessorio= arrayDuplicado;
		}
	}


}
