package classesInicias;

public class Funcionario {

	private Pessoa funcionario;
	private String funcao;
	private String login;
	private String senha;


	public Funcionario(){


	}

	public Funcionario(Pessoa funcionario ,String login,String senha,String funcao){

		this.funcionario = funcionario;
		this.login = login;
		this.senha = senha;
		this.funcao = funcao ;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public Pessoa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	public String toString() {
		return "Funcionario [func=" + funcionario + ", funcao=" + funcao + "]";
	}






}
