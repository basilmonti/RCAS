package rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class RCDetailView {

	@FXML
	private TabPane tabRCMain;
	@FXML
	private ResourceBundle resources;
	@FXML
	private Label lblRCTitle;
	private Stage stage;

	@FXML
	public void initialize() {

	}

	public void btnMMMonClick(ActionEvent actionEvent) {
		//TODO Create SubWindow unmodular with MMMDiagramm
		try
		{
			stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(StartWindowViewController.class.getResource("../../RCASMainView.fxml"));
			ResourceBundle resourceBundle = ResourceBundle.getBundle("RCASResources");
			fxmlLoader.setResources(resourceBundle);

			Parent root = fxmlLoader.load();

			stage.setScene(new Scene(root));
			stage.show();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void btnDeleteonClick(ActionEvent actionEvent) {
		//TODO Delete Car in JSON and go to Main Menu
	}

	public void btnUndoonClick(ActionEvent actionEvent) {
		//TODO Reload the controls from JSON Data
	}

	public void btnSaveonClick(ActionEvent actionEvent) {
		//TODO Post Data to JSON
	}
}
