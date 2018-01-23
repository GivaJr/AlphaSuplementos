package exceptions;

import classesInicias.Pessoa;

@SuppressWarnings("serial")
public class JaExistePessoaException extends Exception{

	private Pessoa pessoa;

	public JaExistePessoaException(Pessoa p) {
		super("a pessoa " + p + " já existe no sistema");
		this.pessoa = p;
	}
	public Pessoa getPessoa() {

		return pessoa;
	}


}
