package classesInicias;

public class Suplemento extends Produto {

	// private Produto produto;

	private String marca;
	private int peso;
	private String sabor;
	private String  categoria;



	public Suplemento(){

	}
	public Suplemento(Produto produto,String marca,int peso, String sabor,String categoria){
		//this.produto = produto;
		super(produto.getNome(),produto.getCodigo(), produto.getPreco());
		this.marca = marca;
		this.categoria = categoria;
		this.peso = peso;
		this.sabor = sabor;
	}


	/*public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}*/


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




	public String toString() {
		return "Suplemento [marca=" + marca + ", sabor=" + sabor + ", getNome()=" + getNome() + "]";
	}













}
