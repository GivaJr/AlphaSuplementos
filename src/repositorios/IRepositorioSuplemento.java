package repositorios;

import java.util.List;

import classesInicias.Suplemento;

public interface IRepositorioSuplemento {

	void adicionarSuplemento(Suplemento suplemento);
	void removerSuplemento(String codigo);
	boolean atualizarSuplemento(String codigo , Suplemento suplemento);
	Suplemento buscarSuplemento(String codigo);
	boolean existeSuplemento(String codigo);
	List<Suplemento> listarSuplementos();
	 
	
}
