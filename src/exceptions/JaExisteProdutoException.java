package exceptions;

import classesInicias.Produto;

@SuppressWarnings("serial")
public class JaExisteProdutoException extends Exception {

	private Produto produto;

	public JaExisteProdutoException(Produto p) {
		super("ja existe"+ p + "cadastrado no sistema");
		this.produto = p;
	}

	public Produto getProduto() {

		return produto;
	}

}
