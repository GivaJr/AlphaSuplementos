package classesInicias;

import java.util.Date;

public class Venda {

	private Cliente cliente;
	private Suplemento suplemento;
	private Acessorio acessorio;
	private double totalDaCompra;
	private Date dataDaCompra;


	public Venda(){


	}

	public Venda(Suplemento suplemento, Cliente cliente, Acessorio acessorio,double total, Date dataDaCompra ){

		this.cliente = cliente;
		this.suplemento = suplemento;
		this.acessorio = acessorio;
		this.totalDaCompra = total;
		this.dataDaCompra = dataDaCompra;
	}

	public Venda( Cliente cliente, Acessorio acessorio,double total, Date dataDaCompra ){

		this.cliente = cliente;
		this.acessorio = acessorio;
		this.totalDaCompra = total;
		this.dataDaCompra = dataDaCompra;
		
	}

	public Venda(Suplemento suplemento, Cliente cliente,double total, Date dataDaCompra){

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
	public Acessorio getAcessorio() {
		return acessorio;
	}
	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
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

	public Date getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(Date dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	
}
