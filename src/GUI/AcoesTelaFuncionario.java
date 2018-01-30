package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import classesInicias.Funcionario;
import classesInicias.Pessoa;
import controlador.Fachada;
import exceptions.JaExistePessoaException;
import exceptions.NaoExistePessoaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AcoesTelaFuncionario implements Initializable {

	
	
	
	Fachada fachada = (Fachada) Fachada.getInstance();
	
	@FXML
	private TextField nome;
	@FXML
	private TextField CPF;
	@FXML
	private TextField funcao;
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnCancelar;

	@FXML
	public void btnCadastrarAcao(ActionEvent e)throws JaExistePessoaException, IOException {
		
		try {
			String n = nome.getText().toString();
			String cpf = CPF.getText().toString();
			String password = senha.getText().toString();
			String f = funcao.getText().toString();
			String l= login.getText().toString();
			
			if (!(n.equals("") || cpf.equals("") || password.equals("") || f.equals("") || l.equals(""))) {
				Pessoa p = new Pessoa(n,cpf);
				Funcionario func = new Funcionario(p,l,password,f);
				fachada.adicionarFuncionario(func);
				Alert alert = new Alert(AlertType.INFORMATION, "Funcionario cadastrado com sucesso!");
				alert.setTitle("Confirmação");
				alert.showAndWait();
				
				
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Campos preenchidos incorretamente!");
				alert.show();
			}
		} catch (JaExistePessoaException pe) {
			Alert alert = new Alert(AlertType.ERROR,"Não é possível cadastrar 2 pessoas com mesmo CPF, tente novamente!");
			alert.show();
		} finally {
			limparCamposCadastrar();
		}
	}	
		
	public void limparCamposCadastrar() {
		nome.setText("");
		CPF.setText("");
		senha.setText("");
		login.setText("");
		funcao.setText("");
	}



	@FXML
	public void btnCancelarAcao(ActionEvent e) throws IOException {

		Parent  pane = FXMLLoader.load(getClass().getResource("TelaMenu.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();

	}
	
	
	
	@FXML
	private Button ok;
	@FXML
	private Button cancelar;
	@FXML
	private TextField cadastroPessoaFisica;
	
	@FXML
	public void btnOKAcao(ActionEvent e) throws NaoExistePessoaException {
		
		try {
		String cpf = cadastroPessoaFisica.getText().toString();
		if(!(cpf.equals(""))) {
			fachada.removerFuncionario(cpf);
			Alert alert = new Alert(AlertType.INFORMATION, "Funcionario removido com sucesso!");
			alert.setTitle("Confirmação");
			alert.showAndWait();
			limparCamposDeRemocao();
			
			}else {
				Alert alert = new Alert(AlertType.ERROR, "Campos preenchidos incorretamente!");
				alert.show();
				}
		}catch (NaoExistePessoaException ee) {
			Alert alert = new Alert(AlertType.ERROR,
					"CPF invalido, tente novamente!");
			alert.show();
		}finally {
			limparCamposDeRemocao();
			}
	}
	
	public void limparCamposDeRemocao() {
		
		cadastroPessoaFisica.setText("");
	}
	
	
	
	@FXML 
	private ListView<Funcionario> listaFuncionario;
	
	private List<Funcionario> listaFuncionario1 = new ArrayList<Funcionario>();
	private ObservableList<Funcionario> f;
	
	@FXML
	public void listarFuncionarios() {

		listaFuncionario1.addAll(fachada.listarFuncionario());
		f = FXCollections.observableArrayList(listaFuncionario1);
		listaFuncionario.getItems().addAll(f);
	}
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listarFuncionarios();
		
	}

	
	
}
