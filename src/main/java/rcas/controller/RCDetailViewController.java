package rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import rcas.model.Converter;
import rcas.model.Member;
import rcas.model.RC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class RCDetailViewController implements Initializable{
	@FXML
	public GridPane tabGridPaneTOPBasicData;
	@FXML
	public TextField txtNameName;
	@FXML
	public TextField txtNameBasicData1;
	@FXML
	public TextField txtNameBasicData2;
	@FXML
	public TextField txtNameBasicData3;
	@FXML
	public TextField txtNameBasicData4;
	@FXML
	public TextField txtNameBasicData5;
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
	public TextField txtNameTireName;
	@FXML
	public TextField txtNameTireData1;
	@FXML
	public TextField txtNameTireData2;
	@FXML
	public TextField txtNameTireData3;
	@FXML
	public TextField txtNameTireData4;
	@FXML
	public TextField txtNameTireData5;
	@FXML
	public TextField txtNameRearTireName;
	@FXML
	public TextField txtNameRearTireData1;
	@FXML
	public TextField txtNameRearTireData2;
	@FXML
	public TextField txtNameRearTireData3;
	@FXML
	public TextField txtNameRearTireData4;
	@FXML
	public TextField txtNameRearTireData5;
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
	private RC rc;

	public RCDetailViewController(RC rc)
	{
		this.rc = rc;
	}

	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		//Base Data
		txtNameName.setText(rc.getName());
		txtNameName.setTooltip(new Tooltip("Der Name ist eindeutig und darf nicht 2-Mal verwendet werden."));
		txtNameBasicData1.setText(String.valueOf(rc.getFrontTrack()));
		txtNameBasicData1.setUserData(new Pair(1.3, 2.2));
		txtNameBasicData1.setTooltip(new Tooltip("Wertebereich: Min = 1.3; Max = 2.2"));
		txtNameBasicData2.setText(String.valueOf(rc.getRearTrack()));
		txtNameBasicData2.setUserData(new Pair(1.3, 2.2));
		txtNameBasicData2.setTooltip(new Tooltip("Wertebereich: Min = 1.3; Max = 2.2"));
		txtNameBasicData3.setText(String.valueOf(rc.getWheelbase()));
		txtNameBasicData3.setUserData(new Pair(1.5, 5.0));
		txtNameBasicData3.setTooltip(new Tooltip("Wertebereich: Min = 1.5; Max = 5.0"));
		txtNameBasicData4.setText(String.valueOf(rc.getCogHeight()));
		txtNameBasicData4.setUserData(new Pair(0.1, 1.2));
		txtNameBasicData4.setTooltip(new Tooltip("Wertebereich: Min = 0.1; Max = 1.2"));
		txtNameBasicData5.setText(String.valueOf(rc.getFrontRollDist()));
		txtNameBasicData5.setUserData(new Pair(0.2, 0.8));
		txtNameBasicData5.setTooltip(new Tooltip("Wertebereich: Min = 0.2; Max = 0.8"));

		//Corner Weight
		if(rc.getCornerWeightFL() > 0.0){txtNameCornerWeight1.setText(String.valueOf(rc.getCornerWeightFL())); txtNameCornerWeight1.setUserData(new Pair(100.0, 1200.0)); txtNameCornerWeight1.setTooltip(new Tooltip("Wertebereich: Min = 100.0; Max = 1200.0"));}
		if(rc.getCornerWeightFR() > 0.0){txtNameCornerWeight2.setText(String.valueOf(rc.getCornerWeightFR())); txtNameCornerWeight2.setUserData(new Pair(100.0, 1200.0)); txtNameCornerWeight2.setTooltip(new Tooltip("Wertebereich: Min = 100.0; Max = 1200.0"));}
		if(rc.getCornerWeightRL() > 0.0){txtNameCornerWeight3.setText(String.valueOf(rc.getCornerWeightRL())); txtNameCornerWeight3.setUserData(new Pair(100.0, 1200.0)); txtNameCornerWeight3.setTooltip(new Tooltip("Wertebereich: Min = 100.0; Max = 1200.0"));}
		if(rc.getCornerWeightRR() > 0.0){txtNameCornerWeight4.setText(String.valueOf(rc.getCornerWeightRR())); txtNameCornerWeight4.setUserData(new Pair(100.0, 1200.0)); txtNameCornerWeight4.setTooltip(new Tooltip("Wertebereich: Min = 100.0; Max = 1200.0"));}

		//Tire Data
		if(!Objects.equals(rc.getFrontAxleTireModel().getName(), "")){txtNameTireName.setText(rc.getFrontAxleTireModel().getName());}
		if(rc.getFrontAxleTireModel().getSlipAngleCoefficientC() > 0.0){txtNameTireData1.setText(String.valueOf(rc.getFrontAxleTireModel().getSlipAngleCoefficientC())); txtNameTireData1.setUserData(new Pair(0.5, 3.0)); txtNameTireData1.setTooltip(new Tooltip("Wertebereich: Min = 0.5; Max = 3.0"));}
		if(rc.getFrontAxleTireModel().getSlipAngleCoefficientB() > 0.0){txtNameTireData2.setText(String.valueOf(rc.getFrontAxleTireModel().getSlipAngleCoefficientB())); txtNameTireData2.setUserData(new Pair(5.0, 30.0)); txtNameTireData2.setTooltip(new Tooltip("Wertebereich: Min = 5.0; Max = 30.0"));}
		if(rc.getFrontAxleTireModel().getSlipAngleCoefficientE() > 0.0){txtNameTireData3.setText(String.valueOf(rc.getFrontAxleTireModel().getSlipAngleCoefficientE())); txtNameTireData3.setUserData(new Pair(-3.0, 3.0)); txtNameTireData3.setTooltip(new Tooltip("Wertebereich: Min = -3.0; Max = 3.0"));}
		if(rc.getFrontAxleTireModel().getLoadCoefficientKA() > 0.0){txtNameTireData4.setText(String.valueOf(rc.getFrontAxleTireModel().getLoadCoefficientKA())); txtNameTireData4.setUserData(new Pair(1.0, 5.0)); txtNameTireData4.setTooltip(new Tooltip("Wertebereich: Min = 1.0; Max = 5.0"));}
		if(rc.getFrontAxleTireModel().getLoadCoefficientKB() > 0.0){txtNameTireData5.setText(String.valueOf(rc.getFrontAxleTireModel().getLoadCoefficientKB())); txtNameTireData5.setUserData(new Pair(0.000010, 0.000090)); txtNameTireData5.setTooltip(new Tooltip("Wertebereich: Min = 0.000010; Max = 0.000090"));}

		if(!Objects.equals(rc.getRearAxleTireModel().getName(), "")){txtNameRearTireName.setText(rc.getRearAxleTireModel().getName());}
		if(rc.getRearAxleTireModel().getSlipAngleCoefficientC() > 0.0){txtNameRearTireData1.setText(String.valueOf(rc.getRearAxleTireModel().getSlipAngleCoefficientC())); txtNameRearTireData1.setUserData(new Pair(0.5, 3.0));  txtNameRearTireData1.setTooltip(new Tooltip("Wertebereich: Min = 100.0; Max = 1200.0"));}
		if(rc.getRearAxleTireModel().getSlipAngleCoefficientB() > 0.0){txtNameRearTireData2.setText(String.valueOf(rc.getRearAxleTireModel().getSlipAngleCoefficientB())); txtNameRearTireData2.setUserData(new Pair(5.0, 30.0)); txtNameRearTireData2.setTooltip(new Tooltip("Wertebereich: Min = 5.0; Max = 30.0"));}
		if(rc.getRearAxleTireModel().getSlipAngleCoefficientE() > 0.0){txtNameRearTireData3.setText(String.valueOf(rc.getRearAxleTireModel().getSlipAngleCoefficientE())); txtNameRearTireData3.setUserData(new Pair(-3.0, 3.0)); txtNameRearTireData3.setTooltip(new Tooltip("Wertebereich: Min = -3.0; Max = 3.0"));}
		if(rc.getRearAxleTireModel().getLoadCoefficientKA() > 0.0){txtNameRearTireData4.setText(String.valueOf(rc.getRearAxleTireModel().getLoadCoefficientKA())); txtNameRearTireData4.setUserData(new Pair(1.0, 5.0)); txtNameRearTireData4.setTooltip(new Tooltip("Wertebereich: Min = 1.0; Max = 5.0"));}
		if(rc.getRearAxleTireModel().getLoadCoefficientKB() > 0.0){txtNameRearTireData5.setText(String.valueOf(rc.getRearAxleTireModel().getLoadCoefficientKB())); txtNameRearTireData5.setUserData(new Pair(0.000010, 0.000090)); txtNameRearTireData5.setTooltip(new Tooltip("Wertebereich: Min = 0.000010; Max = 0.000090"));}
	}


	public void btnMMMonClick(ActionEvent actionEvent) {
		try
		{
			stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/RCASMainView.fxml"));
			ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
			fxmlLoader.setResources(resourceBundle);

			RCASMainViewController controller = new RCASMainViewController(rc);
			fxmlLoader.setController(controller);
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
		String json;
		Member data;
		try
		{
			json = readAllBytesJava7("D:\\Dokumente\\TBZ Module\\M120\\RaceCarAnalysisStudio_V_1_0\\RaceCarAnalysisStudio\\src\\main\\java\\rcas.json");
			data = Converter.fromJsonString(json);
		}catch (Exception e)
		{
			data = null;
		}
		List<RC> carlist = new ArrayList<>(Arrays.asList(data.getRC()));
		for (RC car: carlist) {
			if(car.getName().equals(rc.getName()))
			{
				carlist.remove(car);
				break;
			}
		}
		RC[] rcs = new RC[carlist.size()];
		rcs = carlist.toArray(rcs);
		data.setRC(rcs);
		try {
			writeAllBytesJava7("D:\\Dokumente\\TBZ Module\\M120\\RaceCarAnalysisStudio_V_1_0\\RaceCarAnalysisStudio\\src\\main\\java\\rcas.json", Converter.toJsonString(data));
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		try {
			stage = (Stage) tabRCMain.getScene().getWindow();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/StartWindowView.fxml"));
			ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
			fxmlLoader.setResources(resourceBundle);

			Parent root = fxmlLoader.load();

			stage.setScene(new Scene(root));
			stage.show();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void btnUndoonClick(ActionEvent actionEvent) {
		//TODO Reload the controls from JSON Data
		String json;
		Member data;
		try
		{
			json = readAllBytesJava7("D:\\Dokumente\\TBZ Module\\M120\\RaceCarAnalysisStudio_V_1_0\\RaceCarAnalysisStudio\\src\\main\\java\\rcas.json");
			data = Converter.fromJsonString(json);
		}catch (Exception e)
		{
			data = null;
		}
		List<RC> carlist = new ArrayList<>(Arrays.asList(data.getRC()));
		for (RC car: carlist) {
			if(car.getName().equals(rc.getName()))
			{
				txtNameName.setText(car.getName());
				txtNameBasicData1.setText(String.valueOf(car.getFrontTrack()));
				txtNameBasicData2.setText(String.valueOf(car.getRearTrack()));
				txtNameBasicData3.setText(String.valueOf(car.getWheelbase()));
				txtNameBasicData4.setText(String.valueOf(car.getCogHeight()));
				txtNameBasicData5.setText(String.valueOf(car.getFrontRollDist()));

				//Corner Weight
				if(rc.getCornerWeightFL() > 0.0){txtNameCornerWeight1.setText(String.valueOf(car.getCornerWeightFL()));}
				if(rc.getCornerWeightFR() > 0.0){txtNameCornerWeight2.setText(String.valueOf(car.getCornerWeightFR()));}
				if(rc.getCornerWeightRL() > 0.0){txtNameCornerWeight3.setText(String.valueOf(car.getCornerWeightRL()));}
				if(rc.getCornerWeightRR() > 0.0){txtNameCornerWeight4.setText(String.valueOf(car.getCornerWeightRR()));}

				//Tire Data
				if(!Objects.equals(car.getFrontAxleTireModel().getName(), "")){txtNameTireName.setText(car.getFrontAxleTireModel().getName());}
				if(rc.getFrontAxleTireModel().getSlipAngleCoefficientC() > 0.0){txtNameTireData1.setText(String.valueOf(car.getFrontAxleTireModel().getSlipAngleCoefficientC()));}
				if(rc.getFrontAxleTireModel().getSlipAngleCoefficientB() > 0.0){txtNameTireData2.setText(String.valueOf(car.getFrontAxleTireModel().getSlipAngleCoefficientB()));}
				if(rc.getFrontAxleTireModel().getSlipAngleCoefficientE() > 0.0){txtNameTireData3.setText(String.valueOf(car.getFrontAxleTireModel().getSlipAngleCoefficientE()));}
				if(rc.getFrontAxleTireModel().getLoadCoefficientKA() > 0.0){txtNameTireData4.setText(String.valueOf(car.getFrontAxleTireModel().getLoadCoefficientKA()));}
				if(rc.getFrontAxleTireModel().getLoadCoefficientKB() > 0.0){txtNameTireData5.setText(String.valueOf(car.getFrontAxleTireModel().getLoadCoefficientKB()));}

				if(!Objects.equals(car.getRearAxleTireModel().getName(), "")){txtNameRearTireName.setText(car.getRearAxleTireModel().getName());}
				if(rc.getRearAxleTireModel().getSlipAngleCoefficientC() > 0.0){txtNameRearTireData1.setText(String.valueOf(car.getRearAxleTireModel().getSlipAngleCoefficientC()));}
				if(rc.getRearAxleTireModel().getSlipAngleCoefficientB() > 0.0){txtNameRearTireData2.setText(String.valueOf(car.getRearAxleTireModel().getSlipAngleCoefficientB()));}
				if(rc.getRearAxleTireModel().getSlipAngleCoefficientE() > 0.0){txtNameRearTireData3.setText(String.valueOf(car.getRearAxleTireModel().getSlipAngleCoefficientE()));}
				if(rc.getRearAxleTireModel().getLoadCoefficientKA() > 0.0){txtNameRearTireData4.setText(String.valueOf(car.getRearAxleTireModel().getLoadCoefficientKA()));}
				if(rc.getRearAxleTireModel().getLoadCoefficientKB() > 0.0){txtNameRearTireData5.setText(String.valueOf(car.getRearAxleTireModel().getLoadCoefficientKB()));}
				break;
			}
		}
		RC[] rcs = new RC[carlist.size()];
		rcs = carlist.toArray(rcs);
		data.setRC(rcs);
		try {
			writeAllBytesJava7("D:\\Dokumente\\TBZ Module\\M120\\RaceCarAnalysisStudio_V_1_0\\RaceCarAnalysisStudio\\src\\main\\java\\rcas.json", Converter.toJsonString(data));
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void btnSaveonClick(ActionEvent actionEvent) {
		try {
			rc.setName(txtNameName.getText());
			rc.setFrontTrack(string2double(txtNameBasicData1.getText(), txtNameBasicData1));
			rc.setRearTrack(string2double(txtNameBasicData2.getText(), txtNameBasicData2));
			rc.setWheelbase(string2double(txtNameBasicData3.getText(), txtNameBasicData3));
			rc.setCogHeight(string2double(txtNameBasicData4.getText(), txtNameBasicData4));
			rc.setFrontRollDist(string2double(txtNameBasicData5.getText(), txtNameBasicData5));

			rc.setCornerWeightFL(string2double(txtNameCornerWeight1.getText(), txtNameCornerWeight1));
			rc.setCornerWeightFR(string2double(txtNameCornerWeight2.getText(), txtNameCornerWeight2));
			rc.setCornerWeightRL(string2double(txtNameCornerWeight3.getText(), txtNameCornerWeight3));
			rc.setCornerWeightRR(string2double(txtNameCornerWeight4.getText(), txtNameCornerWeight4));

			rc.getFrontAxleTireModel().setName(txtNameTireName.getText());
			rc.getFrontAxleTireModel().setSlipAngleCoefficientC(string2double(txtNameTireData1.getText(), txtNameTireData1));
			rc.getFrontAxleTireModel().setSlipAngleCoefficientB(string2double(txtNameTireData2.getText(), txtNameTireData2));
			rc.getFrontAxleTireModel().setSlipAngleCoefficientE(string2double(txtNameTireData3.getText(), txtNameTireData3));
			rc.getFrontAxleTireModel().setLoadCoefficientKA(string2double(txtNameTireData4.getText(), txtNameTireData4));
			rc.getFrontAxleTireModel().setLoadCoefficientKB(string2double(txtNameTireData5.getText(), txtNameTireData5));

			rc.getRearAxleTireModel().setName(txtNameRearTireName.getText());
			rc.getRearAxleTireModel().setSlipAngleCoefficientC(string2double(txtNameRearTireData1.getText(), txtNameRearTireData1));
			rc.getRearAxleTireModel().setSlipAngleCoefficientB(string2double(txtNameRearTireData2.getText(), txtNameRearTireData2));
			rc.getRearAxleTireModel().setSlipAngleCoefficientE(string2double(txtNameRearTireData3.getText(), txtNameRearTireData3));
			rc.getRearAxleTireModel().setLoadCoefficientKA(string2double(txtNameRearTireData4.getText(), txtNameRearTireData4));
			rc.getRearAxleTireModel().setLoadCoefficientKB(string2double(txtNameRearTireData5.getText(), txtNameRearTireData5));

			saveRCtoJSON(rc);
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved!");
			alert.show();
		}catch (Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR, "Ein Feld wurde leer gelassen oder ein Feld entspricht nicht dem Wertebereich");
			alert.show();
		}
	}
	public void saveRCtoJSON(RC rccar)
	{
		String json;
		Member data;
		try
		{
			json = readAllBytesJava7("D:\\Dokumente\\TBZ Module\\M120\\RaceCarAnalysisStudio_V_1_0\\RaceCarAnalysisStudio\\src\\main\\java\\rcas.json");
			data = Converter.fromJsonString(json);
		}catch (Exception e)
		{
			data = null;
		}
		List<RC> carlist = new ArrayList<>(Arrays.asList(data.getRC()));

		for (RC car: carlist) {
			if(car.getName().equals(rccar.getName()))
			{
				carlist.remove(car);
				carlist.add(rccar);
			}
		}
		if (!carlist.contains(rccar))
		{
			carlist.add(rccar);
		}

		RC[] rcs = new RC[carlist.size()];
		rcs = carlist.toArray(rcs);
		data.setRC(rcs);
		try {
			writeAllBytesJava7("D:\\Dokumente\\TBZ Module\\M120\\RaceCarAnalysisStudio_V_1_0\\RaceCarAnalysisStudio\\src\\main\\java\\rcas.json", Converter.toJsonString(data));
		}catch (Exception e)
		{

		}

	}
	private String readAllBytesJava7(String filePath)
	{
		String content = "";
		try
		{
			content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return content;
	}
	private void writeAllBytesJava7(String filePath, String content)
	{
		try (PrintStream out = new PrintStream(new FileOutputStream(filePath))) {
			out.print(content);
		}catch (Exception e)
		{

		}
	}
	private double string2double(String value, TextField form) throws Exception
	{
		Pair keyVal = (Pair) form.getUserData();
		try {
			return validateValue(Double.valueOf(value), keyVal);
		}catch (Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR, "Feld: " + form.getId() + " ist ausserhalb des Wertebereichs! Wertebereich: Min = " + String.valueOf(keyVal.getKey()) + "; Max = " + String.valueOf(keyVal.getValue()));
			alert.show();
			throw new Exception();
		}
	}
	private double validateValue (double value, Pair keyVal) throws Exception {
		if (value >= (double) keyVal.getKey() && value <= (double) keyVal.getValue())
		{
			return value;
		}else
		{
			throw new Exception();
		}
	}
}
