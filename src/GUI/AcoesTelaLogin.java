package GUI;

import javafx.scene.control.Button;
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
import javafx.stage.Stage;

public class AcoesTelaLogin implements Initializable{

	@FXML
	private Button entrar;
	@FXML
	private Button cancelar;
	
	@FXML
	public void btnEntrarAcao(ActionEvent e) {
		
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
