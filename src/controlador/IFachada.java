package controlador;

import java.util.List;

import classesInicias.Cliente;
import classesInicias.Funcionario;
import classesInicias.Suplemento;
import exceptions.JaExistePessoaException;
import exceptions.JaExisteSuplementoException;
import exceptions.NaoExistePessoaException;
import exceptions.NaoExisteSuplementoException;

public interface IFachada {

	void adicionarCliente(Cliente cliente)throws JaExistePessoaException;
	void removerCliente(String cpf)throws NaoExistePessoaException;
	void atualizarCliente(String cpf, Cliente cliente);
	Cliente buscarCliente(String cpf);
	List<Cliente> listarCliente();


	void adicionarFuncionario(Funcionario funcionario)throws JaExistePessoaException;
	void removerFuncionario(String cpf) throws NaoExistePessoaException;
	void atualizarFuncionario(String cpf, Funcionario funcionario);
	Funcionario buscarFuncionario(String cpf);
	List<Funcionario> listarFuncionario();


	void adicionarSuplemento(Suplemento suplemento) throws JaExisteSuplementoException;
	void removerSuplemento(String codigo) throws NaoExisteSuplementoException;
	void atualizarSuplemento(String codigo, Suplemento suplemento);
	Suplemento buscarSuplemento(String codigo);
	List<Suplemento> listarSuplemento();


}
