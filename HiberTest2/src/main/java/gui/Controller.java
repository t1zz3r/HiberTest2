package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Contact;
import models.Group;
import models.Model;
import services.ContactService;
import services.GroupService;
import services.Service;

public class Controller {

    static {

    }
    Service service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Group> groupsLIstView;

    @FXML
    private ListView<Contact> contactsListView;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField telephoneTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private Button addContactButton;

    @FXML
    private Button addGroupButton;

    @FXML
    void initialize() {

        addContactButton.setOnAction(event -> {
            Stage stage = (Stage) addContactButton.getScene().getWindow();
            stage.close();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("add.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Добавление контакта");
            stage.setScene(new Scene(root));
            stage.show();
        });

        addGroupButton.setOnAction(event -> {
            Stage stage = (Stage) addGroupButton.getScene().getWindow();
            stage.close();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("addGroup.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Добавление группы");
            stage.setScene(new Scene(root));
            stage.show();
        });

        groupsLIstView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        ObservableList<Group> groupsList = FXCollections.observableArrayList();
        ObservableList<Contact> contactsList = FXCollections.observableArrayList();

        try {
            service = new ContactService();
            List<Contact> contacts = ((ContactService) service).findAllContacts();
            if (!contacts.isEmpty()) {
                contactsList.addAll(contacts);
                contactsListView.setItems(contactsList);
            }

            service = new GroupService();
            List<Group> groups = ((GroupService) service).findAllGroups();
            if (!groups.isEmpty()) {
                groupsList.addAll(groups);
                groupsLIstView.setItems(groupsList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        contactsListView.setOnMouseClicked(this::getInfo);
    }

    @FXML
    void getInfo(MouseEvent event) {
        if (contactsListView.getSelectionModel().getSelectedItem()!= null) {
            int id = (contactsListView.getSelectionModel().getSelectedItem().getId());
            service = new ContactService();

            Contact contact = ((ContactService) service).findContact(id);

                surnameTextField.setText(contact.getLastname());
                nameTextField.setText(contact.getFirstname());
                telephoneTextField.setText(contact.getTelephone());
                addressTextField.setText(contact.getAddress());
        }
    }
}


