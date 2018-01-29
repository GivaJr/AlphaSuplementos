package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaInicial extends Application {

	
	public void start(Stage arg0) throws Exception {
		Parent pane = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
		Scene scene = new Scene(pane);
		arg0.setScene(scene);
		arg0.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
