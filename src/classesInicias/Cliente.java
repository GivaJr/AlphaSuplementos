package classesInicias;

public class Cliente extends Pessoa {

	
	private String objetivo;

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

	public String toString() {
		return "Cliente [objetivo=" + objetivo + ", Nome =" + getNome() + "]";
	}







}
