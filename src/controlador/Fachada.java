package controlador;

import classesInicias.Cliente;
import classesInicias.Funcionario;
import classesInicias.Suplemento;

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


	public void adicionarFuncionario(Funcionario funcionario) {
		f.adicionarFuncionario(funcionario);
	}


	public void removerFuncionario(String cpf) {
		f.removerFuncionario(cpf);
	}


	public boolean atualizarFuncionario(String cpf, Funcionario funcionario) {
		return f.atualizarFuncionario(cpf, funcionario);
	}


	public Funcionario buscarFuncionario(String cpf) {
		return f.buscarFuncionario(cpf);
	}


	public void adicionarSuplemento(Suplemento suplemento) {
		s.adicionarSuplemento(suplemento);
	}


	public void removerSuplemento(String codigo) {
		s.removerSuplemento(codigo);
	}


	public boolean atualizarSuplemento(String codigo, Suplemento suplemento) {
		return s.atualizarSuplemento(codigo, suplemento);
	}


	public Suplemento buscarSuplemento(String codigo) {
		return s.buscarSuplemento(codigo);
	}


}
