package main.java.rcas.controller;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.GridPane;
import main.java.rcas.model.MagicFormulaTireModel;
import main.java.rcas.model.RC;
import main.java.rcas.model.RaceCar;
import main.java.rcas.model.TireModel;
import main.java.rcas.util.CorneringAnalyserUtil;

public class RCASMainViewController implements Initializable {

	@FXML
	private GridPane mainPane;
	@FXML
	private LineChart<Number, Number> mainChart;
	@FXML
	private ResourceBundle resources;
	private RC rc;

	public RCASMainViewController(RC rc)
	{
		this.rc = rc;
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {

		RaceCar myRaceCar_1 = rc.toRaceCar();
		CorneringAnalyserUtil corneringUtil = new CorneringAnalyserUtil();

		// show balance, grip, control and stability values of the cars.
		this.printRaceCarCorneringValues(myRaceCar_1, corneringUtil);

		ObservableList<Series<Number, Number>> dataList_1 = corneringUtil.generateMMMChartData(myRaceCar_1);
		mainChart.getData().addAll(dataList_1);
		// Set the style of the series after adding the data to the chart.
		// Otherwise no there is no reference "Node" which leads to a
		// NullPointerException.
		this.setSeriesStyle(dataList_1, ".chart-series-line", "-fx-stroke: blue; -fx-stroke-width: 1px;");

	}

	private void setSeriesStyle(ObservableList<Series<Number, Number>> dataList_1, String styleSelector,
			String lineStyle) {
		for (Iterator<Series<Number, Number>> iterator = dataList_1.iterator(); iterator.hasNext();) {
			Series<Number, Number> curve = (Series<Number, Number>) iterator.next();
			curve.getNode().lookup(styleSelector).setStyle(lineStyle);
		}
	}

	private void printRaceCarCorneringValues(RaceCar raceCar, CorneringAnalyserUtil util) {
		System.out.println(String.format(
				"%s: Grip = %.2f G\tBalance = %.2f Nm\tControl(entry) = %.2f Nm/deg\t"
						+ "Control(middle) = %.2f Nm/deg\tStability(entry) = %.2f Nm/deg\t"
						+ "Stability(middle) = %.2f Nm/deg",
				raceCar.getName(), util.getMMMGripValue(raceCar) / 9.81, util.getMMMBalanceValue(raceCar),
				util.getMMMControlValue(raceCar, 0.0, 0.0, 10.0), util.getMMMControlValue(raceCar, -5.0, 20.0, 30.0),
				util.getMMMStabilityValue(raceCar, 0.0, 0.0, 1.0),
				util.getMMMStabilityValue(raceCar, 20.0, -5.0, -4.0)));
	}
}
