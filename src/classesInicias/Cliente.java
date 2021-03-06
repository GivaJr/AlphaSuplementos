package classesInicias;

import java.io.Serializable;
import java.util.List;

public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = -185420181319286064L;
	private String objetivo;
	private List<Suplemento> listaSuplementos;

	public Cliente (){

	}
	public Cliente(Pessoa cliente, String objetivo){
		
		super(cliente.getNome(), cliente.getCpf());
		this.objetivo = objetivo;
	}
	
	
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<Suplemento> getListaSuplementos() {
		return listaSuplementos;
	}
	public void setListaSuplementos(Suplemento s) {
		this.listaSuplementos.add(s);
	}
	public String toString() {
		return "Cliente [objetivo=" + objetivo + ", Nome =" + getNome() + "]";
	}







}
