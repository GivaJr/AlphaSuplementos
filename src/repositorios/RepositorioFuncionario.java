package repositorios;

import classesInicias.Funcionario;

public class RepositorioFuncionario {

	private Funcionario[] repositorioFuncionario;
	private int numeroDeFuncionario;



	public RepositorioFuncionario(int tamanho){
		this.repositorioFuncionario = new Funcionario[tamanho];
		this.numeroDeFuncionario = 0 ;


	}


	public void adicionarFuncionario(Funcionario funcionario){
		if (funcionario != null && this.numeroDeFuncionario < repositorioFuncionario.length) {
			this.repositorioFuncionario[numeroDeFuncionario] = funcionario;
			this.numeroDeFuncionario++;
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



}
