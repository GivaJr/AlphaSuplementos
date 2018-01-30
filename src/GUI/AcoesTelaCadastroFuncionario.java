package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import classesInicias.*;
import controlador.Fachada;
import exceptions.JaExistePessoaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class AcoesTelaCadastroFuncionario implements Initializable {

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
		Alert alert = new Alert(AlertType.ERROR,
				"Não é possível cadastrar 2 pessoas com mesmo apelido, tente novamente!");
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

	Parent  pane = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));	
	Scene scene = new Scene(pane);
	Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
	arg.hide();
	arg.setScene(scene);
	arg.show();

}
	

	
	
	
@Override
public void initialize(URL location, ResourceBundle resources) {
		
	}

	
	
}
