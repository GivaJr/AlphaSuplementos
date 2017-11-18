package classesInicias;

public class Acessorio {

	private Produto produto;
	private String marca;



	public Acessorio(){

	}
	public Acessorio(Produto produto, String marca){
		this.produto = produto;
		this.marca = marca;
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

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acessorio other = (Acessorio) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	public String toString() {
		return "Acessorio [produto=" + produto + ", marca=" + marca + "]";
	}



}
