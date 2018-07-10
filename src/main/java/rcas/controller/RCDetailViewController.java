package main.java.rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.rcas.model.RaceCar;

import java.net.URL;
import java.util.ResourceBundle;

public class RCDetailViewController implements Initializable{
	@FXML
	public GridPane tabGridPaneTOPBasicData;
	@FXML
	public TextField txtNameBasicData1;
	@FXML
	public TextField txtNameBasicData2;
	@FXML
	public TextField txtNameBasicData3;
	@FXML
	public TextField txtNameBasicData4;
	@FXML
	public Button btnMMMBasicData;
	@FXML
	public Button btnDeleteBasicData;
	@FXML
	public Button btnUndoBasicData;
	@FXML
	public Button btnSaveBasicData;
	@FXML
	public GridPane tabGridPaneTOPCornerWeight;
	@FXML
	public TextField txtNameCornerWeight1;
	@FXML
	public TextField txtNameCornerWeight2;
	@FXML
	public TextField txtNameCornerWeight3;
	@FXML
	public TextField txtNameCornerWeight4;
	@FXML
	public Button btnMMMCornerWeight;
	@FXML
	public Button btnDeleteCornerWeight;
	@FXML
	public Button btnUndoCornerWeight;
	@FXML
	public Button btnSaveCornerWeight;
	@FXML
	public GridPane tabGridPaneTOPTireData;
	@FXML
	public TextField txtNameTireData1;
	@FXML
	public TextField txtNameTireData2;
	@FXML
	public TextField txtNameTireData3;
	@FXML
	public TextField txtNameTireData4;
	@FXML
	public Button btnMMMTireData;
	@FXML
	public Button btnDeleteTireData;
	@FXML
	public Button btnUndoTireData;
	@FXML
	public Button btnSaveTireData;
	@FXML
	public TabPane tabRCMain;
	@FXML
	private Stage stage;
	private RaceCar rc;

	public RCDetailViewController(RaceCar rc)
	{
		this.rc = rc;
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		txtNameBasicData1.setText(rc.getFrontTrack().toString());
	}

	public void  setRC(RaceCar rc)
	{
		this.rc = rc;
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
