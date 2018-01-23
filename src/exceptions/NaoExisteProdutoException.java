package exceptions;

import classesInicias.Produto;

@SuppressWarnings("serial")
public class NaoExisteProdutoException extends Exception {

	private Produto produtoNaoExiste;

	public NaoExisteProdutoException(Produto p) {

		super("o seguinte produto" + p + "\n não existe no sistema");
		this.produtoNaoExiste = p;

	}


	public Produto getProduto() {

		return produtoNaoExiste;
	}
}
