package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AcoesTelaMenu implements Initializable {

	
	@FXML
	private Button cliente;
	@FXML
	private Button funcionario;
	@FXML
	private Button suplemento;
	@FXML
	private Button cancelar;
	
	
	@FXML
	public void btnClienteAcao(ActionEvent e) throws IOException {
		
		Parent  pane = FXMLLoader.load(getClass().getResource("TelaCliente.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();
	}
	@FXML
	public void btnFuncionarioAcao(ActionEvent e) throws IOException {
		Parent  pane = FXMLLoader.load(getClass().getResource("TelaFuncionario.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();
		
	}
	@FXML
	public void btnSuplementoAcao(ActionEvent e) throws IOException {
		Parent  pane = FXMLLoader.load(getClass().getResource("TelaSuplemento.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();
		
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
