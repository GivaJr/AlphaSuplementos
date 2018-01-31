package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import classesInicias.Cliente;
import classesInicias.Pessoa;
import classesInicias.Suplemento;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AcoesTelaCliente  implements Initializable{

	Fachada fachada = (Fachada) Fachada.getInstance();

	@FXML 
	private TextField nome;
	@FXML
	private TextField objetivo;
	@FXML
	private TextField CPF;

	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnCancelar;

	public void btnCadastrarAcao(ActionEvent e)throws  JaExistePessoaException,IOException {

		try {
			String n = nome.getText().toString();
			String obj = objetivo.getText().toString();
			String cpf = CPF.getText().toString();

			if(!(n.equals("")||obj.equals("")||cpf.equals(""))) {
				Pessoa p = new Pessoa(n,cpf);
				Cliente c = new Cliente(p,obj);
				fachada.adicionarCliente(c);
				Alert alert = new Alert(AlertType.INFORMATION, "Cliente cadastrado com sucesso!");
				alert.setTitle("Confirmação");
				alert.showAndWait();
			}else {
				Alert alert = new Alert(AlertType.ERROR, "Campos preenchidos incorretamente!");
				alert.show();
			}

		}catch (JaExistePessoaException e1) {

			Alert alert = new Alert(AlertType.ERROR,"Não é possível cadastrar 2 pessoas com mesmo CPF, tente novamente!");
			alert.show();
		}finally {
			limparCamposCadastrar();
		}

	}

	public void limparCamposCadastrar() {
		nome.setText("");
		CPF.setText("");
		objetivo.setText("");
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
				fachada.removerCliente(cpf);
				Alert alert = new Alert(AlertType.INFORMATION, "Cliente removido com sucesso!");
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

	//lista de clientes 

	@FXML 
	private ListView<Cliente> listaCliente;

	private List<Cliente> listaCliente1 = new ArrayList<Cliente>();
	private ObservableList<Cliente> c;

	@FXML
	public void listarCliente() {

		listaCliente1.addAll(fachada.listarCliente());
		c = FXCollections.observableArrayList(listaCliente1);
		listaCliente.getItems().addAll(c);
	}



	//Suplementos para o cliente

	@FXML
	private ComboBox<Cliente> lista;

	private List<Cliente> listarCliente1 = new ArrayList<>();
	private ObservableList<Cliente> obsLista;

	@FXML
	public void listarCliente1() {
		listarCliente1.addAll(fachada.listarCliente());
		obsLista = FXCollections.observableArrayList(listarCliente1);

		lista.getItems().addAll(obsLista);
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


	@FXML
	private Button add;
	@FXML
	private Button del;

	@FXML
	private ListView<Suplemento> viewSuplementosCliente;
	private ObservableList<Suplemento> suplementosPessoa;



	@FXML
	public void pegarComboSelecionado()  {
		try {
			viewSuplementosCliente.getItems().clear();
			Cliente p = lista.getSelectionModel().getSelectedItem();


			if (listaSuplementos.getSelectionModel().getSelectedItem() != null) {
				Suplemento Sup = listaSuplementos.getSelectionModel().getSelectedItem();

				List<Suplemento> s = p.getListaSuplementos();
				boolean verificar = false;
				if (s.size() == 0) {
					p.setListaSuplementos(Sup);
					fachada.atualizarCliente(p.getCpf() , p);


				} else {
					for (int i = 0; i < s.size(); i++) {
						if (Sup.equals(s.get(i))) {
							verificar = true;
						}
					}
					if (!verificar) {
						p.setListaSuplementos(Sup);

					} else {
						Alert alert = new Alert(AlertType.ERROR,
								"Suplemento já cadastrado para este cliente! Não é possível cadastrar o mesmo suplemento!");
						alert.show();
					}
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Você não selecionou um suplemento 00000!");
				alert.show();
			}
			suplementosPessoa = FXCollections.observableArrayList(p.getListaSuplementos());
			viewSuplementosCliente.getItems().addAll(suplementosPessoa);
		} catch (NullPointerException npe) {
			Alert alert = new Alert(AlertType.ERROR, "Você não selecionou uma suplemento1111111!");
			alert.show();
		}
	}

	@FXML
	public void pegarCombo() {

		viewSuplementosCliente.getItems().clear();
		Cliente c = lista.getSelectionModel().getSelectedItem();
		suplementosPessoa = FXCollections.observableArrayList(c.getListaSuplementos());
		Collections.shuffle(suplementosPessoa);
		viewSuplementosCliente.getItems().addAll(suplementosPessoa);


	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listarCliente();
		listarCliente1();
		listarSuplementos();

	}



}
