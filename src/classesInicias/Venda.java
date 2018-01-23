package classesInicias;

import java.time.*;

public class Venda {

	private Cliente cliente;
	private Suplemento suplemento;
	
	private double totalDaCompra;
	private LocalDate dataDaCompra;


	public Venda(){

	}


	public Venda(Suplemento suplemento, Cliente cliente,double total,LocalDate dataDaCompra){

		this.cliente = cliente;
		this.suplemento = suplemento;
		this.totalDaCompra = total;
		this.dataDaCompra = dataDaCompra;
	}


	public Suplemento getSuplemento() {
		return suplemento;
	}
	public void setSuplemento(Suplemento suplemento) {
		this.suplemento = suplemento;
	}
	
	public double getTotalDaCompra() {
		return totalDaCompra;
	}
	public void setTotalDaCompra(double totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	
	
	
}
