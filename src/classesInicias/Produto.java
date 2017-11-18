package classesInicias;

public class Produto {

	private String nome;
	private double preco;
	private String codigo;



	public  Produto(){

	}


	public Produto (String nome,String codigo,double preco){

		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}


	public String getCodigo() {
		return codigo;
	}

	public double getPreco(){
		return preco;

	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String toString() {
		return "Produto =" + nome +"";
	}



}
