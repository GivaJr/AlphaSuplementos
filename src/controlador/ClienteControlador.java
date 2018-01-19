package controlador;

import classesInicias.Cliente;
import repositorios.RepositorioCliente;

public class ClienteControlador {

	private RepositorioCliente rp = new RepositorioCliente(100);

	public void adicionarCliente(Cliente cliente){
		
		if(!this.rp.existeCliente(cliente.getCpf())) {
			
			this.rp.adicionarCliente(cliente);
		}else {
			
			// tratar com exception 
		}
		
	}


	public void removerCliente(String cpf){
		Cliente c = this.rp.buscarCliente(cpf);   
		
		if(c != null && c.getCpf().equals(cpf)){	
		
			rp.removerCliente(cpf);
		
		}else {
			
			//Tratar com exception
		}
	}

	
	public void atualizarCliente(String cpf, Cliente cliente){
		
		if(!this.existeCliente(cliente.getCpf())){
			this.rp.atualizarCliente(cpf, cliente);
		}
		

	}


	public Cliente buscarCliente(String cpf){
		Cliente c = null;
		if(this.existeCliente(cpf)){

			c =  rp.buscarCliente(cpf);
		}
		return c;
	}

	
	public boolean existeCliente(String cpf) {

		return this.rp.existeCliente(cpf);
	}

}
