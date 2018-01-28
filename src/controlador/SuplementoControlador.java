package controlador;

import java.util.List;

import classesInicias.Suplemento;
import exceptions.JaExisteSuplementoException;
import exceptions.NaoExisteSuplementoException;
import repositorios.RepositorioSuplemento;

public class SuplementoControlador {

	private RepositorioSuplemento rp = new RepositorioSuplemento(100);

	public void adicionarSuplemento(Suplemento suplemento) throws JaExisteSuplementoException  {

		if(!this.rp.existeSuplemento(suplemento.getCodigo())) {
			
			this.rp.adicionarSuplemento(suplemento);
		}else {
			
			throw new JaExisteSuplementoException(suplemento);
		}
	}


	public void removerSuplemento(String codigo)throws NaoExisteSuplementoException{
		Suplemento s = this.rp.buscarSuplemento(codigo);
		if( s!= null && s.getCodigo().equals(codigo)){
			
			this.rp.removerSuplemento(codigo);
		
		}else {
	
			throw new NaoExisteSuplementoException(s);
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

	
	public List<Suplemento> listarSuplemento(){
		
		return this.rp.listarSuplementos();
	}



}
