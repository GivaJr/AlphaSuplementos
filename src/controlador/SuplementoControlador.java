package controlador;

import classesInicias.Suplemento;
import repositorios.RepositorioSuplemento;

public class SuplementoControlador {
	
	private RepositorioSuplemento rp = new RepositorioSuplemento(100);
	
	public void adicionarSuplemento(Suplemento suplemento){
		if(suplemento != null){
			rp.adicionarSuplemento(suplemento);
		}
	}
   public void removerSuplemento(String codigo){
	   rp.removerSuplemento(codigo);
	   
   }

   public boolean atualizarSuplemento(String codigo, Suplemento suplemento){
	    return rp.atualizarSuplemento(codigo, suplemento);
	   
   }

   public Suplemento buscarSuplemento(String codigo){
	   return rp.buscarSuplemento(codigo);
	   
   }

}
