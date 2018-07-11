package main.java.rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.rcas.model.Converter;
import main.java.rcas.model.Member;
import main.java.rcas.model.RC;
import main.java.rcas.model.RaceCar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StartWindowViewOpenController {
	@FXML
	public TextField lblOpen;
	@FXML
	private GridPane mainPane;
	@FXML
	private ResourceBundle resources;
	@FXML
    private Stage stage;
		private RC car;

	@FXML
	public void initialize() {

	}

	public void lblOpenAction(ActionEvent actionEvent) {
		try
		{
			String json = readAllBytesJava7("C:\\Users\\bmontemitro\\Documents\\RCAS\\src\\main\\java\\rcas.json");
			Member data = Converter.fromJsonString(json);
			if (lblOpen.getText() != "")
			{
				car = searchRC(data.getRC(), lblOpen.getText());
			}
			else{
				Alert alert = new Alert(Alert.AlertType.ERROR, "Das Feld darf nicht leer sein!");
				alert.show();
				throw new Exception();
			}
			if (car == null)
			{
				Alert alert = new Alert(Alert.AlertType.ERROR, "Das Auto wurde nicht gefunden");
				alert.show();
				throw new Exception();
			}


			stage = (Stage) mainPane.getScene().getWindow();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/RCDetailView.fxml"));
			ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
			fxmlLoader.setResources(resourceBundle);

			RCDetailViewController controller = new RCDetailViewController(car);
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
	private RC searchRC(RC[] rcs, String carname)
	{
		List<RC> carlist = new ArrayList<>(Arrays.asList(rcs));
		for(RC car : carlist)
		{
			if(Objects.equals(car.getName(), carname))
			{
				return car;
			}
		}
		return null;
	}
}
