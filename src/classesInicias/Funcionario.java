package classesInicias;

public class Funcionario extends Pessoa {


	private String funcao;
	private String login;
	private String senha;


	public Funcionario(){


	}

	public Funcionario(Pessoa funcionario ,String login,String senha,String funcao){

	
		super(funcionario.getNome(), funcionario.getCpf());
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	public String toString() {
		return "Funcionario [funcao=" + funcao + ", getNome()=" + getNome() + "]";
	}
	
	
}
