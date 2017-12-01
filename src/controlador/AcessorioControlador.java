package controlador;

import classesInicias.Acessorio;
import repositorios.RepositorioAcessorio;

public class AcessorioControlador {
	private RepositorioAcessorio rp = new RepositorioAcessorio(100);

	public void adicionarAcessorio(Acessorio acessorio){
		if(acessorio != null){
			rp.adicionarAcessorio(acessorio);
		}
	}
	public void removerAcessorio(String codigo){
		rp.removerAcessorio(codigo);

	}

	public boolean atualizarCliente(String codigo, Acessorio acessorio){
		return rp.atualizarProduto(codigo, acessorio);

	}

	public Acessorio buscarAcessorio(String codigo){
		return rp.buscarAcessorio(codigo);

	}


}
