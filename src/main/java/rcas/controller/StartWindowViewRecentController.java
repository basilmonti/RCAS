package main.java.rcas.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.rcas.model.Converter;
import main.java.rcas.model.Member;
import main.java.rcas.model.RC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StartWindowViewRecentController {

	@FXML
	public ListView listViewRecent;
	@FXML
	private GridPane mainPane;
	@FXML
	private ResourceBundle resources;
    @FXML
    private Button btnRecentCar;
    @FXML
    private Stage stage;
    private RC car;

	@FXML
	public void initialize() {
		String json = readAllBytesJava7("C:\\Users\\bmontemitro\\Documents\\RCAS\\src\\main\\java\\rcas.json");
		Member data = new Member();
		try {
			data = Converter.fromJsonString(json);
		}catch (Exception e)
		{

		}
		ObservableList items = FXCollections.observableArrayList(getCarList(data.getRC()));
		listViewRecent.setItems(items);
	}

	public void handleRecentCarBtn(ActionEvent actionEvent) {
	    //TODO Connect to RC Main Menu with default Values
		try
		{
			if(listViewRecent.getSelectionModel().getSelectedItem() != null)
			{
				car = (RC)listViewRecent.getSelectionModel().getSelectedItem();
			}
			else
			{
				Alert alert = new Alert(Alert.AlertType.ERROR, "Kein Element ausgewählt!");
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
	private List<RC> getCarList(RC[] rcs)
	{
		return new ArrayList<>(Arrays.asList(rcs));
	}
}