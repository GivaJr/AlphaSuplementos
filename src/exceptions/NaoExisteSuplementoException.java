package exceptions;

import classesInicias.Suplemento;

@SuppressWarnings("serial")
public class NaoExisteSuplementoException extends Exception {

	private Suplemento suplementoNaoExiste;

	public NaoExisteSuplementoException(Suplemento s) {

		super("o seguinte produto" + s + "\n não existe no sistema");
		this.suplementoNaoExiste = s;

	}


	public Suplemento getSuplemento() {

		return suplementoNaoExiste;
	}
}
