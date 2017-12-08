import classesInicias.Cliente;
import classesInicias.Funcionario;
import classesInicias.Pessoa;
import classesInicias.Produto;
import classesInicias.Suplemento;
import controlador.Fachada;

public class Teste {

	public static void main(String[] args) {
        Pessoa p1 = new Pessoa("joão","1079182918928");
        Pessoa p2 = new Pessoa("Givanildo","11191829172918");
        Cliente c1 = new Cliente(p1,"Hipertrofia"); 
        Cliente c2 = new Cliente(p1,"Baixar o BF");
		Funcionario F1 = new Funcionario(p2,"giva_9","121212","Gerente");
		Funcionario F2 = new Funcionario(p2,"giva_9","121212","Dono");
		Produto pr1 = new Produto("Whey Protein ","123",50.0,"Gold");
		Suplemento S1 = new Suplemento(pr1,2,"morango","Hipertrofia");
		Suplemento S2 = new Suplemento(pr1,4,"morango","trofia");
		
		// Adicionar
		Fachada.getInstance().adicionarCliente(c1);
		Fachada.getInstance().adicionarFuncionario(F1);
		Fachada.getInstance().adicionarSuplemento(S1);
		

		//Buscar
		Fachada.getInstance().buscarCliente(c1.getCpf());
		Fachada.getInstance().buscarFuncionario(F1.getCpf());
		Fachada.getInstance().buscarSuplemento(S1.getCodigo());
		
		System.out.println(Fachada.getInstance().buscarCliente(c1.getCpf()));
		System.out.println(Fachada.getInstance().buscarFuncionario(F1.getCpf()));
		System.out.println(	Fachada.getInstance().buscarSuplemento(S1.getCodigo()));
		
		//Atualizar 
		
		Fachada.getInstance().atualizarCliente(c1.getCpf(), c2 );
		Fachada.getInstance().atualizarFuncionario(F1.getCpf(),F2);
		Fachada.getInstance().atualizarSuplemento(S1.getCodigo(),S2);
		
		System.out.println(Fachada.getInstance().buscarCliente(c1.getCpf()));
		System.out.println(Fachada.getInstance().buscarFuncionario(F1.getCpf()));
		System.out.println(	Fachada.getInstance().buscarSuplemento(S1.getCodigo()));
		
		
		
		//Remover
		Fachada.getInstance().removerCliente(c1.getCpf());
		Fachada.getInstance().removerFuncionario(F1.getCpf());
		Fachada.getInstance().removerSuplemento(S1.getCodigo());
		
		System.out.println(Fachada.getInstance().buscarCliente(c1.getCpf()));
		System.out.println(Fachada.getInstance().buscarFuncionario(F1.getCpf()));
		System.out.println(	Fachada.getInstance().buscarSuplemento(S1.getCodigo()));
		
		
		
	}

}
