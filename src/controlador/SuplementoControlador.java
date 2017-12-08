package controlador;

import classesInicias.Suplemento;
import repositorios.RepositorioSuplemento;

public class SuplementoControlador {

	private RepositorioSuplemento rp = new RepositorioSuplemento(100);

	public void adicionarSuplemento(Suplemento suplemento){
		if(suplemento != null){
			if(!this.existeSuplemento(suplemento.getCodigo())){
				rp.adicionarSuplemento(suplemento);
			}
		}
	}


	public void removerSuplemento(String codigo){
		Suplemento s = this.rp.buscarSuplemento(codigo);
		if( s!= null){
			rp.removerSuplemento(codigo);
		}
	}



	public boolean atualizarSuplemento(String codigo, Suplemento suplemento){
		boolean r = false;
		if(this.existeSuplemento(codigo)){
			r = rp.atualizarSuplemento(codigo, suplemento);
		}
		return r;
	}


	public Suplemento buscarSuplemento(String codigo){
		Suplemento s = null;
		if(this.existeSuplemento(codigo)){
			s = rp.buscarSuplemento(codigo);
		}
		return s;
	}


	public boolean existeSuplemento(String codigo) {


		return this.rp.existeSuplemento(codigo);
	}


}
