package rcas.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import rcas.model.MagicFormulaTireModel;
import rcas.model.RaceCar;
import rcas.model.TireModel;
import rcas.util.CorneringAnalyserUtil;

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

public class StartWindowViewController {

	@FXML
	private GridPane mainPane;
	@FXML
	private ResourceBundle resources;
    @FXML
    private Button btnNewCar;
    @FXML
    private Button btnOpenCar;
    @FXML
    private Button btnRecentCar;
    private Stage stage;

	@FXML
	public void initialize() {

	}

	public void handleNewCarBtn(ActionEvent actionEvent) {
	    //TODO Connect to RC Main Menu with default Values
		try
		{
			stage = (Stage) mainPane.getScene().getWindow();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(StartWindowViewController.class.getResource("../../RCDetailView.fxml"));
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

	public void handleOpenCarBtn(ActionEvent actionEvent) {
	    //TODO set all Buttons invisible and create New for search. Search RC in JSON
	}

	public void handleRecentCarBtn(ActionEvent actionEvent) {
	    //TODO set all Buttons invisible and create ListView or Dropdown
	}
}
