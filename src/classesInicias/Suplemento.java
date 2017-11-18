package classesInicias;

public class Suplemento {
 
 private Produto produto;
 private String marca;
 private int peso;
 private String sabor;
 private String  categoria;
 

	
	public Suplemento(){
		
	}
	public Suplemento(Produto produto,String marca,int peso, String sabor,String categoria){
		this.produto = produto;
		this.marca = marca;
		this.categoria = categoria;
		this.peso = peso;
		this.sabor = sabor;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPeso() {
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suplemento other = (Suplemento) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	
	public String toString() {
		return "Suplemento [produto=" + produto + ", marca=" + marca + ", peso=" + peso + ", sabor=" + sabor
				+ ", categoria=" + categoria + "]";
	}
	
	
	

	
	
	
}
