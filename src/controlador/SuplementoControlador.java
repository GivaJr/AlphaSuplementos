package controlador;

import classesInicias.Suplemento;
import repositorios.RepositorioSuplemento;

public class SuplementoControlador {

	private RepositorioSuplemento rp = new RepositorioSuplemento(100);

	public void adicionarSuplemento(Suplemento suplemento){

		if(!this.rp.existeSuplemento(suplemento.getCodigo())) {
			
			this.rp.adicionarSuplemento(suplemento);
		}else {
			
			// tratar com exception 
		}
	}


	public void removerSuplemento(String codigo){
		Suplemento s = this.rp.buscarSuplemento(codigo);
		if( s!= null && s.getCodigo().equals(codigo)){
			
			this.rp.removerSuplemento(codigo);
		
		}else {
		// TRATAR COM EXCEPTION	
			
		}
	}



	public void atualizarSuplemento(String codigo, Suplemento suplemento){
	
		if(!this.existeSuplemento(suplemento.getCodigo())){
			this.rp.atualizarSuplemento(codigo, suplemento);
		}
	
	}


	public Suplemento buscarSuplemento(String codigo){
		Suplemento s = null;
		if(this.existeSuplemento(codigo)){
			s = this.rp.buscarSuplemento(codigo);
		}
		return s;
	}


	public boolean existeSuplemento(String codigo) {


		return this.rp.existeSuplemento(codigo);
	}


}
