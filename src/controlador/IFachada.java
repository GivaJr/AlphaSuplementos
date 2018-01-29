package controlador;

import classesInicias.Cliente;
import classesInicias.Funcionario;
import classesInicias.Suplemento;
import exceptions.JaExistePessoaException;
import exceptions.JaExisteSuplementoException;
import exceptions.NaoExistePessoaException;
import exceptions.NaoExisteSuplementoException;

public interface IFachada {

	void adicionarCliente(Cliente cliente);
	void removerCliente(String cpf);
	void atualizarCliente(String cpf, Cliente cliente);
	Cliente buscarCliente(String cpf);


	void adicionarFuncionario(Funcionario funcionario)throws JaExistePessoaException;
	void removerFuncionario(String cpf) throws NaoExistePessoaException;
	void atualizarFuncionario(String cpf, Funcionario funcionario);
	Funcionario buscarFuncionario(String cpf);


	void adicionarSuplemento(Suplemento suplemento) throws JaExisteSuplementoException;
	void removerSuplemento(String codigo) throws NaoExisteSuplementoException;
	void atualizarSuplemento(String codigo, Suplemento suplemento);
	Suplemento buscarSuplemento(String codigo);


}
