package main.java.rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.rcas.model.Converter;
import main.java.rcas.model.Member;
import main.java.rcas.model.RC;
import main.java.rcas.model.RaceCar;

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
		txtNameBasicData1.setText(String.valueOf(rc.getFrontTrack()));
		txtNameBasicData2.setText(String.valueOf(rc.getRearTrack()));
		txtNameBasicData3.setText(String.valueOf(rc.getWheelbase()));
		txtNameBasicData4.setText(String.valueOf(rc.getCogHeight()));
		txtNameBasicData5.setText(String.valueOf(rc.getFrontRollDist()));

		//Corner Weight
		if(rc.getCornerWeightFL() > 0.0){txtNameCornerWeight1.setText(String.valueOf(rc.getCornerWeightFL()));}
		if(rc.getCornerWeightFR() > 0.0){txtNameCornerWeight2.setText(String.valueOf(rc.getCornerWeightFR()));}
		if(rc.getCornerWeightRL() > 0.0){txtNameCornerWeight3.setText(String.valueOf(rc.getCornerWeightRL()));}
		if(rc.getCornerWeightRR() > 0.0){txtNameCornerWeight4.setText(String.valueOf(rc.getCornerWeightRR()));}

		//Tire Data
		if(!Objects.equals(rc.getFrontAxleTireModel().getName(), "")){txtNameTireName.setText(rc.getFrontAxleTireModel().getName());}
		if(rc.getFrontAxleTireModel().getSlipAngleCoefficientC() > 0.0){txtNameTireData1.setText(String.valueOf(rc.getFrontAxleTireModel().getSlipAngleCoefficientC()));}
		if(rc.getFrontAxleTireModel().getSlipAngleCoefficientB() > 0.0){txtNameTireData2.setText(String.valueOf(rc.getFrontAxleTireModel().getSlipAngleCoefficientB()));}
		if(rc.getFrontAxleTireModel().getSlipAngleCoefficientE() > 0.0){txtNameTireData3.setText(String.valueOf(rc.getFrontAxleTireModel().getSlipAngleCoefficientE()));}
		if(rc.getFrontAxleTireModel().getLoadCoefficientKA() > 0.0){txtNameTireData4.setText(String.valueOf(rc.getFrontAxleTireModel().getLoadCoefficientKA()));}
		if(rc.getFrontAxleTireModel().getLoadCoefficientKB() > 0.0){txtNameTireData5.setText(String.valueOf(rc.getFrontAxleTireModel().getLoadCoefficientKB()));}

		if(!Objects.equals(rc.getRearAxleTireModel().getName(), "")){txtNameRearTireName.setText(rc.getRearAxleTireModel().getName());}
		if(rc.getRearAxleTireModel().getSlipAngleCoefficientC() > 0.0){txtNameRearTireData1.setText(String.valueOf(rc.getRearAxleTireModel().getSlipAngleCoefficientC()));}
		if(rc.getRearAxleTireModel().getSlipAngleCoefficientB() > 0.0){txtNameRearTireData2.setText(String.valueOf(rc.getRearAxleTireModel().getSlipAngleCoefficientB()));}
		if(rc.getRearAxleTireModel().getSlipAngleCoefficientE() > 0.0){txtNameRearTireData3.setText(String.valueOf(rc.getRearAxleTireModel().getSlipAngleCoefficientE()));}
		if(rc.getRearAxleTireModel().getLoadCoefficientKA() > 0.0){txtNameRearTireData4.setText(String.valueOf(rc.getRearAxleTireModel().getLoadCoefficientKA()));}
		if(rc.getRearAxleTireModel().getLoadCoefficientKB() > 0.0){txtNameRearTireData5.setText(String.valueOf(rc.getRearAxleTireModel().getLoadCoefficientKB()));}
	}


	public void btnMMMonClick(ActionEvent actionEvent) {
		//TODO Create SubWindow unmodular with MMMDiagramm
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
		//TODO Delete Car in JSON and go to Main Menu
	}

	public void btnUndoonClick(ActionEvent actionEvent) {
		//TODO Reload the controls from JSON Data
	}

	public void btnSaveonClick(ActionEvent actionEvent) {
		//TODO Post Data to JSON
		rc.setName(txtNameName.getText());
		rc.setFrontTrack(Double.valueOf(txtNameBasicData1.getText()));
		rc.setRearTrack(Double.valueOf(txtNameBasicData2.getText()));
		rc.setWheelbase(Double.valueOf(txtNameBasicData3.getText()));
		rc.setCogHeight(Double.valueOf(txtNameBasicData4.getText()));
		rc.setFrontRollDist(Double.valueOf(txtNameBasicData5.getText()));

		rc.setCornerWeightFL(Double.valueOf(txtNameCornerWeight1.getText()));
		rc.setCornerWeightFR(Double.valueOf(txtNameCornerWeight2.getText()));
		rc.setCornerWeightRL(Double.valueOf(txtNameCornerWeight3.getText()));
		rc.setCornerWeightRR(Double.valueOf(txtNameCornerWeight4.getText()));

		rc.getFrontAxleTireModel().setName(txtNameTireName.getText());
		rc.getFrontAxleTireModel().setSlipAngleCoefficientC(Double.valueOf(txtNameTireData1.getText()));
		rc.getFrontAxleTireModel().setSlipAngleCoefficientB(Double.valueOf(txtNameTireData2.getText()));
		rc.getFrontAxleTireModel().setSlipAngleCoefficientE(Double.valueOf(txtNameTireData3.getText()));
		rc.getFrontAxleTireModel().setLoadCoefficientKA(Double.valueOf(txtNameTireData4.getText()));
		rc.getFrontAxleTireModel().setLoadCoefficientKB(Double.valueOf(txtNameTireData5.getText()));

		rc.getRearAxleTireModel().setName(txtNameRearTireName.getText());
		rc.getRearAxleTireModel().setSlipAngleCoefficientC(Double.valueOf(txtNameRearTireData1.getText()));
		rc.getRearAxleTireModel().setSlipAngleCoefficientB(Double.valueOf(txtNameRearTireData2.getText()));
		rc.getRearAxleTireModel().setSlipAngleCoefficientE(Double.valueOf(txtNameRearTireData3.getText()));
		rc.getRearAxleTireModel().setLoadCoefficientKA(Double.valueOf(txtNameRearTireData4.getText()));
		rc.getRearAxleTireModel().setLoadCoefficientKB(Double.valueOf(txtNameRearTireData5.getText()));

		saveRCtoJSON(rc);
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved!");
		alert.show();
	}
	public void saveRCtoJSON(RC rccar)
	{
		String json;
		Member data;
		try
		{
			json = readAllBytesJava7("C:\\Users\\bmontemitro\\Documents\\RCAS\\src\\main\\java\\rcas.json");
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
			writeAllBytesJava7("C:\\Users\\bmontemitro\\Documents\\RCAS\\src\\main\\java\\rcas.json", Converter.toJsonString(data));
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
}
