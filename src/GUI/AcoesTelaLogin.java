package GUI;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classesInicias.Funcionario;
import controlador.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AcoesTelaLogin implements Initializable{

	Fachada fachada = (Fachada) Fachada.getInstance();

	@FXML
	private Button entrar;
	@FXML
	private Button cancelar;
	@FXML 
	private TextField login;
	@FXML
	private PasswordField senha;

	@FXML
	public void TelaMenu(ActionEvent e ) throws IOException {
		Parent  pane = FXMLLoader.load(getClass().getResource("TelaMenu.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();
	}





	@FXML
	public void btnEntrarAcao(ActionEvent e) throws IOException {

		String l = login.getText().toString();
		String s = senha.getText().toString();
		Funcionario f = new Funcionario();

		if(l.equals(f.getLogin()) && s.equals(f.getSenha())) {
			Alert alert = new Alert(AlertType.INFORMATION, "Bem-vindo ao AlphaSuplementos");
			alert.setTitle("Bem-Vindo");
			alert.showAndWait();
			TelaMenu(e);
		}else if(fachada.login(l, s)) {
			Alert alert = new Alert(AlertType.INFORMATION, "Bem-vindo ao AlphaSuplementos");
			alert.setTitle("Bem-Vindo");
			alert.showAndWait();
			TelaMenu(e);
		}else {
			Alert alert = new Alert(AlertType.INFORMATION, "Login ou senha errada!");
			alert.setTitle("Falha ao entrar!");
			alert.showAndWait();
		}




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
	public void initialize(URL arg0, ResourceBundle arg1) {

	}



}
