package repositorios;

import classesInicias.Pessoa;

public class RepositorioPessoa {


	private Pessoa[] repositorioPessoa;
	private int numeroDePessoas;


	public RepositorioPessoa (int tamanho){
		this.repositorioPessoa = new Pessoa[tamanho];
		this.numeroDePessoas = 0;
	}


	public void adicionarPessoa(Pessoa pessoa) {
		if (pessoa != null && this.numeroDePessoas < repositorioPessoa.length) {
			this.repositorioPessoa[numeroDePessoas] = pessoa;
			this.numeroDePessoas++;
		}
	}


	public Pessoa buscarPessoa(String cpf){
		int i;
		Pessoa retorno = null;
		for(i=0;i < numeroDePessoas; i++){
			if(this.repositorioPessoa[i].getCpf() == cpf){
				retorno = this.repositorioPessoa[i];
			}

		}
		return retorno;

	}

	public void RemoverPessoa(String cpf){
		int i;
		for(i=0; i < numeroDePessoas ; i++){
			if(this.repositorioPessoa[i].getCpf() == cpf){
				this.repositorioPessoa[i]= this.repositorioPessoa[numeroDePessoas -1];
				this.repositorioPessoa[numeroDePessoas-1]=null;
				this.numeroDePessoas--;
			}
		}

	}


	public boolean atualizarPessoa(String cpf,Pessoa pessoa){
		boolean retorno = false;
		int i;
		for(i=0;i<numeroDePessoas;i++){
			if(this.repositorioPessoa[i].getCpf() == cpf){
				this.repositorioPessoa[i]=pessoa;
				retorno= true;
			}
		}
		return retorno;
	}


}
