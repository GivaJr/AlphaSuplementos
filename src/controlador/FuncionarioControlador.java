package controlador;


import classesInicias.Funcionario;
import repositorios.RepositorioFuncionario;


public class FuncionarioControlador {


	private RepositorioFuncionario rp = new RepositorioFuncionario(100);

	public void adicionarFuncionario(Funcionario funcionario){
		
		if(!this.rp.existeFuncionario(funcionario.getCpf())) {
			
			this.rp.adicionarFuncionario(funcionario);
		}else {
			
			// tratar com exception 
		}
	}

	public void removerFuncionario(String cpf){
		Funcionario f = this.rp.buscarFuncionario(cpf);
		
		if(f != null && f.getCpf().equals(cpf)){
			this.rp.removerFuncionario(cpf);
		}else {
			
			//tratar com exceptions
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


}
