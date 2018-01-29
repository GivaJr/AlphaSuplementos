package repositorios;

import java.util.List;

import classesInicias.Cliente;

public interface IRepositorioCliente {
	
	void adicionarCliente(Cliente cliente);
	void removerCliente(String cpf);
	boolean atualizarCliente(String cpf, Cliente cliente);
	Cliente buscarCliente(String cpf);
	void duplicaArrayRepositorio();
	boolean existeCliente(String cpf);
	int procurarCliente(String cpf);
	List<Cliente> listarCliente();
	

}
