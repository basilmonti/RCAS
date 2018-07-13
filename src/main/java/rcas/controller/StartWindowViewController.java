package rcas.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import rcas.model.AxleTireModel;
import rcas.model.RC;

import java.util.ResourceBundle;
public class StartWindowViewController {
    @FXML
    public Label lblStart;
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
		try
		{
			stage = (Stage) mainPane.getScene().getWindow();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/RCDetailView.fxml"));
			ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
			fxmlLoader.setResources(resourceBundle);
            RC car = new RC();
            car.setName("RaceCar");
            car.setFrontTrack(1.6);
            car.setRearTrack(1.6);
            car.setWheelbase(2.6);
            car.setCogHeight(0.5);
            car.setFrontRollDist(0.5);
            car.setFrontAxleTireModel(new AxleTireModel());
            car.setRearAxleTireModel(new AxleTireModel());
            RCDetailViewController controller = new RCDetailViewController(car);
            fxmlLoader.setController(controller);

            TabPane root = fxmlLoader.load();


			stage.setScene(new Scene(root));
			stage.show();

		}
		catch (Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION, e.getMessage());
			alert.show();
			e.printStackTrace();
		}
	}

	public void handleOpenCarBtn(ActionEvent actionEvent) {
        try
        {
            stage = (Stage) mainPane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/StartWindowViewOpen.fxml"));
            ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
            fxmlLoader.setResources(resourceBundle);

            Parent root = fxmlLoader.load();

            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, e.getMessage());
            alert.show();
            e.printStackTrace();
        }
	}

	public void handleRecentCarBtn(ActionEvent actionEvent) {
	    //TODO set all Buttons invisible and create ListView or Dropdown
        try
        {
            stage = (Stage) mainPane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/StartWindowViewRecent.fxml"));
            ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
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

    public void onClicklbl(MouseEvent mouseEvent) {
	    try {
            stage = (Stage) mainPane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("main/java/StartWindowView.fxml"));
            ResourceBundle resourceBundle = ResourceBundle.getBundle("main/java/RCASResources");
            fxmlLoader.setResources(resourceBundle);

            Parent root = fxmlLoader.load();

            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e)
        {

        }
    }
}
