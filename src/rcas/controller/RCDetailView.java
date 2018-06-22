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
		//TODO set Title to Carname from JSON Object. Bind it to Name Property.
		lblRCTitle.setText("Racecar: ");
	}
}
