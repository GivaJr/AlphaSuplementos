package repositorios;


import classesInicias.Cliente;



public class RepositorioCliente {

	private Cliente[] repositorioCliente;
	private int numeroDeCliente;



	public RepositorioCliente(int tamanho){
		this.repositorioCliente = new Cliente[tamanho];
		this.numeroDeCliente = 0 ;


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

}
