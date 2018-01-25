package classesInicias;

import java.util.List;

public class Cliente extends Pessoa {

	
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
	public void setListaSuplementos(List<Suplemento> listaSuplementos) {
		this.listaSuplementos = listaSuplementos;
	}
	public String toString() {
		return "Cliente [objetivo=" + objetivo + ", Nome =" + getNome() + "]";
	}







}
