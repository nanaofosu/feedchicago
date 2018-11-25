package app.controller;

import app.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

public class AddVolunteerController {
    @FXML
    private TextField field_firstname;

    @FXML
    private TextField field_lastname;

    @FXML
    private DatePicker field_date;

    @FXML
    private Boolean field_gender;

    @FXML
    private RadioButton field_gender_female;

    @FXML
    private RadioButton field_gender_male;

    @FXML
    private TextField field_email;

    @FXML
    private TextField field_street_address;

    @FXML
    private TextField field_city;

    @FXML
    private TextField field_state;

    @FXML
    private TextField field_zipcode;

    @FXML
    private TextField field_phone;

    @FXML
    private TextField field_occupation;

    @FXML
    private TextField field_employer;

    @FXML
    private HBox field_driverslicense;

    @FXML
    private RadioButton field_driverslicense_yes;

    @FXML
    private RadioButton field_driverslicense_no;

    @FXML
    private Button field_save;

    public void initialize(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        //set all fields to null
        field_firstname.clear();
        field_lastname.clear();
        field_date.setValue(LocalDate.now());
        field_email.clear();
        field_street_address.clear();
        field_city.clear();
        field_state.clear();
        field_zipcode.clear();
        field_phone.clear();
        field_occupation.clear();
        field_employer.clear();

        //when the save button is clicked gett all the values.
        field_save.setOnAction(event -> {
            field_firstname.getText().trim();
            field_lastname.getText().trim();
            field_date.getValue();
            field_email.getText().trim();
            field_street_address.getText().trim();
            field_city.getText().trim();
            field_state.getText().trim();
            field_zipcode.getText().trim();
            field_phone.getText().trim();
            field_occupation.getText().trim();
            field_employer.getText().trim();


            //call the database connector and run your query
            databaseHandler.addVolunteer();
        });

    }
}
