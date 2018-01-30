package controlador;

import java.util.List;

import classesInicias.Cliente;
import classesInicias.Funcionario;
import classesInicias.Suplemento;
import exceptions.JaExistePessoaException;
import exceptions.JaExisteSuplementoException;
import exceptions.NaoExistePessoaException;
import exceptions.NaoExisteSuplementoException;
import repositorios.RepositorioCliente;
import repositorios.RepositorioFuncionario;
import repositorios.RepositorioSuplemento;

public class Fachada implements IFachada{

	private ClienteControlador c;
	private FuncionarioControlador f;
	private SuplementoControlador s;

	private static IFachada instance;

	private Fachada(){

		this.c = new ClienteControlador(RepositorioCliente.getInstance());
		this.f = new FuncionarioControlador(RepositorioFuncionario.getInstance());
		this.s = new SuplementoControlador(RepositorioSuplemento.getInstance());

	}


	public static IFachada getInstance(){
		if(instance == null ){
			instance = new Fachada();
		}
		return instance;
	}


	public void adicionarCliente(Cliente cliente) throws JaExistePessoaException {
		this.c.adicionarCliente(cliente);
	}
	public void removerCliente(String cpf) throws NaoExistePessoaException {
		this.c.removerCliente(cpf);
	}
	public void atualizarCliente(String cpf, Cliente cliente) {
		this.c.atualizarCliente(cpf, cliente);
	}

	public Cliente buscarCliente(String cpf) {
		return this.c.buscarCliente(cpf);
	}
	public List<Cliente> listarCliente() {

		return this.c.listarCliente();
	}




	public void adicionarFuncionario(Funcionario funcionario)throws JaExistePessoaException {
		this.f.adicionarFuncionario(funcionario);
	}
	public void removerFuncionario(String cpf) throws NaoExistePessoaException{
		this.f.removerFuncionario(cpf);
	}
	public void atualizarFuncionario(String cpf, Funcionario funcionario) {
		this.f.atualizarFuncionario(cpf, funcionario);
	}
	public Funcionario buscarFuncionario(String cpf) {
		return this.f.buscarFuncionario(cpf);
	}

	public List<Funcionario> listarFuncionario() {

		return this.f.listarSuplemento();
	}
	
	public boolean login(String login, String senha) {
		return this.f.login(login, senha);
	}




	public void adicionarSuplemento(Suplemento suplemento) throws JaExisteSuplementoException{
		this.s.adicionarSuplemento(suplemento);
	}

	public void removerSuplemento(String codigo) throws NaoExisteSuplementoException {
		this.s.removerSuplemento(codigo);
	}
	public void atualizarSuplemento(String codigo, Suplemento suplemento) {
		this.s.atualizarSuplemento(codigo, suplemento);
	}
	public Suplemento buscarSuplemento(String codigo) {
		return this.s.buscarSuplemento(codigo);
	}

	public List<Suplemento> listarSuplemento() {

		return this.s.listarSuplemento();
	}




}
 