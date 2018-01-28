package controlador;

import classesInicias.Cliente;
import classesInicias.Funcionario;
import classesInicias.Suplemento;
import exceptions.JaExistePessoaException;
import exceptions.JaExisteSuplementoException;
import exceptions.NaoExistePessoaException;
import exceptions.NaoExisteSuplementoException;

public class Fachada {

	private ClienteControlador c;
	private FuncionarioControlador f;
	private SuplementoControlador s;
	
	private static Fachada instance;
	
	private Fachada(){
		
		this.c = new ClienteControlador();
		this.f = new FuncionarioControlador();
		this.s = new SuplementoControlador();
		
	}
	
	
	public static Fachada getInstance(){
		if(instance == null ){
			instance = new Fachada();
			}
		return instance;
	}


	public void adicionarCliente(Cliente cliente) {
		c.adicionarCliente(cliente);
	}


	public void removerCliente(String cpf) {
		c.removerCliente(cpf);
	}


	public void atualizarCliente(String cpf, Cliente cliente) {
		 c.atualizarCliente(cpf, cliente);
	}


	public Cliente buscarCliente(String cpf) {
		return c.buscarCliente(cpf);
	}


	public void adicionarFuncionario(Funcionario funcionario)throws JaExistePessoaException {
		f.adicionarFuncionario(funcionario);
	}


	public void removerFuncionario(String cpf) throws NaoExistePessoaException{
		f.removerFuncionario(cpf);
	}


	public void atualizarFuncionario(String cpf, Funcionario funcionario) {
		f.atualizarFuncionario(cpf, funcionario);
	}


	public Funcionario buscarFuncionario(String cpf) {
		return f.buscarFuncionario(cpf);
	}


	public void adicionarSuplemento(Suplemento suplemento) throws JaExisteSuplementoException{
		s.adicionarSuplemento(suplemento);
	}


	public void removerSuplemento(String codigo) throws NaoExisteSuplementoException {
		s.removerSuplemento(codigo);
	}


	public void atualizarSuplemento(String codigo, Suplemento suplemento) {
		s.atualizarSuplemento(codigo, suplemento);
	}


	public Suplemento buscarSuplemento(String codigo) {
		return s.buscarSuplemento(codigo);
	}


}
