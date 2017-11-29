package classesInicias;

public class Acessorio extends Produto{

	//private Produto produto;
	private String marca;



	public Acessorio(){

	}
	public Acessorio(Produto produto, String marca){
		//this.produto = produto;

		super(produto.getCodigo(), produto.getNome(), produto.getPreco());
		this.marca = marca;
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





}
