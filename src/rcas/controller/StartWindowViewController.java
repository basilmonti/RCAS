package rcas.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import rcas.model.MagicFormulaTireModel;
import rcas.model.RaceCar;
import rcas.model.TireModel;
import rcas.util.CorneringAnalyserUtil;

import java.util.Iterator;
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

	@FXML
	public void initialize() {

	}

	public void handleNewCarBtn(ActionEvent actionEvent) {
	    //TODO Connect to RC Main Menu with default Values
	}

	public void handleOpenCarBtn(ActionEvent actionEvent) {
	    //TODO set all Buttons invisible and create New for search. Search RC in JSON
	}

	public void handleRecentCarBtn(ActionEvent actionEvent) {
	    //TODO set all Buttons invisible and create ListView or Dropdown
	}
}
