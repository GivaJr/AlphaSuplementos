package controlador;


import java.util.List;

import classesInicias.Funcionario;
import exceptions.JaExistePessoaException;
import exceptions.NaoExistePessoaException;
import repositorios.IRepositorioFuncionario;



public class FuncionarioControlador {


	private IRepositorioFuncionario rp;



	public FuncionarioControlador(IRepositorioFuncionario instancia) {

		this.rp = instancia;
	}



	public void adicionarFuncionario(Funcionario funcionario)throws JaExistePessoaException {

		if(!this.rp.existeFuncionario(funcionario.getCpf())) {

			this.rp.adicionarFuncionario(funcionario);
		}else {

			throw new JaExistePessoaException(funcionario); 
		}
	}



	public void removerFuncionario(String cpf)throws NaoExistePessoaException {
		Funcionario f = this.rp.buscarFuncionario(cpf);

		if(f != null && f.getCpf().equals(cpf)){
			this.rp.removerFuncionario(cpf);
		}else {

			throw new NaoExistePessoaException(f);

		}
	}




	public void atualizarFuncionario(String cpf, Funcionario funcionario){

		if(!this.rp.existeFuncionario(funcionario.getCpf())){
			this.rp.atualizarFuncionario(cpf, funcionario);
		}

	}




	public Funcionario buscarFuncionario(String cpf){
		Funcionario f = null;
		if(this.existeFuncionario(cpf)){
			f = rp.buscarFuncionario(cpf);
		}
		return f;
	}




	public boolean existeFuncionario(String cpf) {

		return this.rp.existeFuncionario(cpf);

	}

	public List<Funcionario> listarSuplemento(){

		return this.rp.listarFuncionario();
	}

	
	public boolean login(String login, String senha) {
		
		return this.rp.login(login, senha);
	}
}
