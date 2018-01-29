package controlador;
import java.util.List;
import classesInicias.Cliente;
import exceptions.JaExistePessoaException;
import exceptions.NaoExistePessoaException;
import repositorios.IRepositorioCliente;

public class ClienteControlador {

	private IRepositorioCliente rp;

	public ClienteControlador(IRepositorioCliente instancia) {
		this.rp = instancia;
	}

	public void adicionarCliente(Cliente cliente)throws JaExistePessoaException{

		if(!this.rp.existeCliente(cliente.getCpf())) {

			this.rp.adicionarCliente(cliente);
		}else {

			throw new JaExistePessoaException(cliente);
		}

	}


	public void removerCliente(String cpf)throws NaoExistePessoaException{
		Cliente c = this.rp.buscarCliente(cpf);   

		if(c != null && c.getCpf().equals(cpf)){	

			this.rp.removerCliente(cpf);

		}else {

			throw new NaoExistePessoaException(c);
		}
	}


	public void atualizarCliente(String cpf, Cliente cliente){

		if(!this.rp.existeCliente(cliente.getCpf())){
			this.rp.atualizarCliente(cpf, cliente);
		}


	}


	public Cliente buscarCliente(String cpf){
		Cliente c = null;
		if(this.rp.existeCliente(cpf)){

			c =  this.rp.buscarCliente(cpf);
		}
		return c;
	}


	public boolean existeCliente(String cpf) {

		return this.rp.existeCliente(cpf);
	}


	public List<Cliente> listarCliente(){

		return this.rp.listarCliente();		
	}


}
