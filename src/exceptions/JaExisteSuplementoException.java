package exceptions;

import classesInicias.Suplemento;

@SuppressWarnings("serial")
public class JaExisteSuplementoException extends Exception {

	private Suplemento s;

	public JaExisteSuplementoException(Suplemento s) {
		super("ja existe"+ s + "cadastrado no sistema");
		this.s = s;
	}

	public Suplemento getSuplemento() {

		return s;
	}

}
