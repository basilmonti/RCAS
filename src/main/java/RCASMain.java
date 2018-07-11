package main.java;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RCASMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/StartWindowView.fxml"));
		ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
		fxmlLoader.setResources(resourceBundle);

		GridPane mainPane = fxmlLoader.load();
		Scene mainScene = new Scene(mainPane, 800, 600);
		primaryStage.centerOnScreen();
		primaryStage.setTitle(resourceBundle.getString("applicationTitle"));
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(RCASMain.class, args);
	}
}
