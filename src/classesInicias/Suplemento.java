package classesInicias;

public class Suplemento extends Produto {



	private int peso;
	private String sabor;
	private String  categoria;



	public Suplemento(){

	}
	public Suplemento(Produto produto,String marca,int peso, String sabor,String categoria){

		super(produto.getNome(),produto.getCodigo(), produto.getPreco(),produto.getMarca());
		this.categoria = categoria;
		this.peso = peso;
		this.sabor = sabor;
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
		return "Suplemento [peso=" + peso + ", sabor=" + sabor + ", categoria=" + categoria + ", getMarca()="
				+ getMarca() + "]";
	}


}
