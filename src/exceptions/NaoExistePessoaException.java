package exceptions;

import classesInicias.Pessoa;

@SuppressWarnings("serial")
public class NaoExistePessoaException extends Exception{


	private Pessoa pessoaNaoExiste;

	public NaoExistePessoaException(Pessoa pessoa) {
		super("A seguinrte pessoa" + pessoa + "\n não existe no sistema");
		this.pessoaNaoExiste = pessoa;
	}

	public Pessoa getPessoaNaoExiste() {

		return pessoaNaoExiste;
	}

}
