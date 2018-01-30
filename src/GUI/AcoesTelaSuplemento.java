package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import classesInicias.Suplemento;
import controlador.Fachada;
import exceptions.JaExisteSuplementoException;
import exceptions.NaoExisteSuplementoException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AcoesTelaSuplemento implements Initializable{


	Fachada fachada = (Fachada) Fachada.getInstance();

	@FXML 
	private TextField nome;
	@FXML
	private TextField codigo;
	@FXML
	private TextField peso;
	@FXML
	private TextField sabor;
	@FXML
	private TextField preco;

	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnCancelar;	

	@FXML
	public void btnCadastrarAcao(ActionEvent event)throws JaExisteSuplementoException, IOException {

		try {
			String n = nome.getText().toString();
			double pc = Double.parseDouble(preco.getText());
			String c = codigo.getText().toString(); 
			double ps = Double.parseDouble(peso.getText()); 
			String s = sabor.getText().toString();

			if(!(n.equals("") || pc<=0 || c.equals("")|| ps <= 0|| s.equals(""))){
				Suplemento gold = new Suplemento(n,pc,c,ps,s);
				fachada.adicionarSuplemento(gold);
				Alert alert = new Alert(AlertType.INFORMATION, "Suplemento cadastrado com sucesso!");
				alert.setTitle("Confirmação");
				alert.showAndWait();

			}  else {
				Alert alert = new Alert(AlertType.ERROR, "Campos preenchidos incorretamente!");
				alert.show();
			}     


		}catch (JaExisteSuplementoException e) {
			Alert alert = new Alert(AlertType.INFORMATION, "Já existe um suplemento com esse codigo, tente novamente!");
			alert.show();
		}finally {
			limparCadastroSuplemento();
		}

	}


	public void limparCadastroSuplemento() {
		nome.setText("");
		codigo.setText("");
		peso.setText(null);
		preco.setText(null);
		sabor.setText("");

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
	private Button btnok;
	@FXML
	private Button btnCancelar1;
	@FXML
	private TextField codigo1;
	
	public void removerSuplemento() throws NaoExisteSuplementoException, IOException{
	try {
		String cdg = codigo1.getText().toString();
		if(!(cdg.equals(""))) {
			fachada.removerSuplemento(cdg);
			Alert alert = new Alert(AlertType.INFORMATION, "Suplemento removido com sucesso!");
			alert.setTitle("Confirmação");
			alert.showAndWait();
			limparCamposDeRemocao();
			
			}else {
				Alert alert = new Alert(AlertType.ERROR, "Campos preenchidos incorretamente!");
				alert.show();
				}
		}catch (NaoExisteSuplementoException ee) {
			Alert alert = new Alert(AlertType.ERROR,
					"Codigo invalido, tente novamente!");
			alert.show();
		}finally {
		limparCamposDeRemocao();
			}
	}
	
	public void limparCamposDeRemocao() {
		codigo1.setText("");
		
	}
	
	@FXML 
	private ListView<Suplemento> listaSuplementos;
	
	private List<Suplemento> listaSuplementos1 = new ArrayList<Suplemento>();
	private ObservableList<Suplemento> s;
	
	@FXML
	public void listarSuplementos() {

		listaSuplementos1.addAll(fachada.listarSuplemento());
		s = FXCollections.observableArrayList(listaSuplementos1);
		listaSuplementos.getItems().addAll(s);
	}
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listarSuplementos();
	}



}
