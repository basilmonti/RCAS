package rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.awt.datatransfer.FlavorEvent;
import java.util.ResourceBundle;

public class RCDetailView {

	@FXML
	private GridPane mainPane;
	@FXML
	private ResourceBundle resources;
	@FXML
	private Label lblRCTitle;

	@FXML
	public void initialize() {

	}

	public void btnMMMonClick(ActionEvent actionEvent) {
		//TODO Create SubWindow unmodular with MMMDiagramm
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
