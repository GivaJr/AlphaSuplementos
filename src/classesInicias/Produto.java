package classesInicias;

public class Produto {

	private String nome;
	private double preco;
	private String codigo;
	private String marca;



	public  Produto(){

	}


	public Produto (String nome,String codigo,double preco,String marca){

		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.marca = marca;
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
	public String getMarca() {
		return marca;
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


	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	public String toString() {
		return "Produto =" + nome +"";
	}



}
