package repositorios;

import java.util.List;
import classesInicias.Funcionario;

public interface IRepositorioFuncionario {
	
	void adicionarFuncionario(Funcionario funcionario);
	void removerFuncionario(String cpf);
	boolean atualizarFuncionario(String cpf , Funcionario funcionario);
	Funcionario buscarFuncionario(String cpf);
	boolean existeFuncionario(String cpf);
	List<Funcionario> listarFuncionario();
	
	

}
