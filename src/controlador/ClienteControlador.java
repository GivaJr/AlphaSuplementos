package controlador;

import classesInicias.Cliente;
import repositorios.RepositorioCliente;

public class ClienteControlador {

	   private RepositorioCliente rp = new RepositorioCliente(100);
		
		public void adicionarCliente(Cliente cliente){
			if(cliente!=null){
				rp.adicionarCliente(cliente);
			}
		}
	   public void removerCliente(String cpf){
		   rp.removerCliente(cpf);
		   
	   }

	   public boolean atualizarCliente(String cpf, Cliente cliente){
		    return rp.atualizarCliente(cpf, cliente);
		   
	   }
	
	   public Cliente buscarCliente(String cpf){
		   return rp.buscarCliente(cpf);
		   
	   }
	
}
