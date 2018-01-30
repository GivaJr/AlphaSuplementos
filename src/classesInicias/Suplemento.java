package classesInicias;

import java.io.Serializable;

public class Suplemento implements Serializable  {

	
	private static final long serialVersionUID = 6995262653438943029L;
	
	private String nome;
	private double preco;
	private String codigo;
	private double peso;
	private String sabor;
	



	public Suplemento(){

	}
	public Suplemento(String nome, double preco, String codigo,double peso, String sabor){

		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
		this.peso = peso;
		this.sabor = sabor;
	}


	public double getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suplemento other = (Suplemento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Suplemento [nome=" + nome + ", sabor=" + sabor + "]";
	}

	

}
