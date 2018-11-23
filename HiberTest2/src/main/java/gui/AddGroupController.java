package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Group;
import services.GroupService;
import services.Service;

public class AddGroupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField groupNameTextField;

    @FXML
    private Button addGroupToDBButton;

    @FXML
    void initialize() {
        addGroupToDBButton.setOnAction(event -> {
            Service service = new GroupService();
            if (groupNameTextField.getText() != null) {
                service.save(new Group(groupNameTextField.getText()));
            }
            Stage stage = (Stage) addGroupToDBButton.getScene().getWindow();
            stage.close();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();

        });
    }
}
