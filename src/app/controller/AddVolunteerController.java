package app.controller;

import app.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private HBox field_gender;

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

    String firstname,  lastname,  dob,  email,  address,  city,  state,  zipcode,  phone,  occupation,  employer;



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

//        ToggleGroup radioGroup = new ToggleGroup();
//        field_gender_female.setToggleGroup(radioGroup);
//        field_gender_male.setToggleGroup(radioGroup);
//        field_gender = new HBox(field_gender_female, field_gender_male);




        //when the save button is clicked gett all the values.
        field_save.setOnAction(event -> {
//            field_firstname.
            firstname = field_firstname.getText();
            lastname = field_lastname.getText();
            dob = field_date.getValue().toString();
            email = field_email.getText();
            address = field_street_address.getText();
            city = field_city.getText();
            state = field_state.getText();
            zipcode = field_zipcode.getText();
            phone = field_phone.getText();
            occupation = field_occupation.getText();
            employer = field_employer.getText();



//            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
//            field_gender = getGender();

            //call the database connector and run your query
            databaseHandler.addVolunteer(firstname, lastname, dob, email, address, city, state, zipcode, phone, occupation, employer);
        });

    }


}
