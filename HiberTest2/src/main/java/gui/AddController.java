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
import models.Contact;
import services.ContactService;
import services.Service;

public class AddController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addSurnameField;

    @FXML
    private TextField addNameField;

    @FXML
    private TextField addTelephoneField;

    @FXML
    private TextField addAddressField;

    @FXML
    private Button addContactToDatabaseButton;

    @FXML
    void initialize() {

        addContactToDatabaseButton.setOnAction(event -> {
            Service service = new Service();
            service.save(new Contact(addSurnameField.getText(), addNameField.getText(), addTelephoneField.getText(), addAddressField.getText()));
            Stage stage = (Stage) addContactToDatabaseButton.getScene().getWindow();
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

