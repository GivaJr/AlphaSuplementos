package classesInicias;

public class Pessoa {

	private String nome;
	private String cpf;


	public Pessoa (){


	}
	public Pessoa (String nome , String cpf){

		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}




}
