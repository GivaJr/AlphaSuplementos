package controlador;

import classesInicias.Cliente;
import repositorios.RepositorioCliente;

public class ClienteControlador {

	private RepositorioCliente rp = new RepositorioCliente(100);

	public void adicionarCliente(Cliente cliente){
		if(cliente!= null){
			if(!this.existeCliente(cliente.getCpf())){

				this.rp.adicionarCliente(cliente);
			}
		}
	}


	public void removerCliente(String cpf){
		Cliente c = this.rp.buscarCliente(cpf);   
		if(c != null){	
			rp.removerCliente(cpf);
		}
	}


	public boolean atualizarCliente(String cpf, Cliente cliente){
		boolean r = false;
		if(this.existeCliente(cpf)){
			r = rp.atualizarCliente(cpf, cliente);
		}
		return r;

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
