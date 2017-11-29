package classesInicias;

public class Cliente extends Pessoa {

	//private Pessoa cliente;
	private String objetivo;

	public Cliente (){

	}
	public Cliente(Pessoa cliente, String objetivo){

		//this.cliente = cliente;
		super(cliente.getNome(), cliente.getCpf());
		this.objetivo = objetivo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}



	/*public Pessoa getCliente() {
		return cliente;
	}



	public String toString() {
		return "Cliente [cliente=" + cliente + "]";
	}*/





}
