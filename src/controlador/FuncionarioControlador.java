package controlador;


import classesInicias.Funcionario;
import repositorios.RepositorioFuncionario;


public class FuncionarioControlador {


	   private RepositorioFuncionario rp = new RepositorioFuncionario(100);
		
		public void adicionarFuncionario(Funcionario funcionario){
			if(funcionario!=null){
				rp.adicionarFuncionario(funcionario);
			}
		}
	   public void removerFuncionario(String cpf){
		   rp.removerFuncionario(cpf);
		   
	   }

	   public boolean atualizarFuncionario(String cpf, Funcionario funcionario){
		    return rp.atualizarFuncionario(cpf, funcionario);
		   
	   }
	
	   public Funcionario buscarFuncionario(String cpf){
		   return rp.buscarFuncionario(cpf);
		   
	   }
	
	
	
}
