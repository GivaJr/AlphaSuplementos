package controlador;


import classesInicias.Funcionario;
import repositorios.RepositorioFuncionario;


public class FuncionarioControlador {


	private RepositorioFuncionario rp = new RepositorioFuncionario(100);

	public void adicionarFuncionario(Funcionario funcionario){
		if(funcionario!=null){
			if(!this.existeFuncionario(funcionario.getCpf()))
				rp.adicionarFuncionario(funcionario);
		}
	}

	public void removerFuncionario(String cpf){
		Funcionario f = this.rp.buscarFuncionario(cpf);
		if(f != null){
			rp.removerFuncionario(cpf);
		}
	}


	public boolean atualizarFuncionario(String cpf, Funcionario funcionario){
		boolean r = false;
		if(this.existeFuncionario(cpf)){
			r = rp.atualizarFuncionario(cpf, funcionario);
		}
		return r;
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


}
