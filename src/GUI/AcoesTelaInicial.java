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

public class AcoesTelaInicial implements Initializable{

	@FXML
	private Button cadastrarFuncionario;
	
	
	@FXML
	public void btnCadastrarFuncionarioAcaos(ActionEvent e)throws IOException {
		
		Parent  pane = FXMLLoader.load(getClass().getResource("TelaCadastroFuncionario.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();
		cadastrarFuncionario.getScene().getWindow().hide();

		
	}
	
	@FXML
	private Button btnlogin;
	
	@FXML
	public void btnLoginAcaos(ActionEvent e) throws IOException {
		
		Parent  pane = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));	
		Scene scene = new Scene(pane);
		Stage arg = (Stage) ((Node) e.getSource()).getScene().getWindow();
		arg.hide();
		arg.setScene(scene);
		arg.show();
	    btnlogin.getScene().getWindow().hide();
		
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	

}
