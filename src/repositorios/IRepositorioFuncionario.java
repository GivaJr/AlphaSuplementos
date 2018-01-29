package repositorios;

import classesInicias.Funcionario;

public interface IRepositorioFuncionario {
	
	void adicionarFuncionario(Funcionario funcionario);
	void removerFuncionario(String cpf);
	boolean atualizarFuncionario(String cpf , Funcionario funcionario);
	Funcionario buscarFuncionario(String cpf);
	void duplicaArrayRepositorio();
	boolean existeFuncionario(String cpf);
	int procurarFuncionario(String cpf);
	

}
