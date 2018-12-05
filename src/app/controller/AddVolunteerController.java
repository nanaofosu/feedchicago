package app.controller;

import app.database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @FXML
    private ToggleGroup gender;

    @FXML
    private ToggleGroup driversLicense;

    ObservableList skills = FXCollections.observableArrayList();

    @FXML
    private ListView fieldSkillList = new ListView(skills);


    private String firstname;
    private String lastname;
    private String dob;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phone;
    private String occupation;
    private String employer;
    private String volunteerGender;
    private String license;
    private String skill;







    public void initialize(){
        //Creating a database handler to use for this controller.
        DatabaseHandler databaseHandler = new DatabaseHandler();

        //set all text fields to null
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


        //Getting the list of skills needed for the project.
        try {
            Statement stmt = databaseHandler.getDbConnection().createStatement();
            String sql = "Select * FROM skill";
            ResultSet rs = stmt.executeQuery(sql);
            String skillname;

            while(rs.next()){
                skillname = rs.getString("skillname");
                skills.add(skillname);
                fieldSkillList.setItems(skills);
            }

            rs.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }




        //when the save button is clicked gett all the values.
        field_save.setOnAction(event -> {
            field_save.disableProperty().bind(field_firstname.textProperty().isEmpty());
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
            skill = fieldSkillList.getSelectionModel().getSelectedItem().toString();

            //get the gender value
            if(field_gender_male.isSelected()){
                volunteerGender = "M";
            }else {
                volunteerGender = "F";
            }

            if(field_driverslicense_yes.isSelected()){
                license = "Yes";
            }else{
                license = "No";
            }

            int selectedSkillID = databaseHandler.getSkillID(skill);
            System.out.println(selectedSkillID);

            //call the database connector and run your query
            int newestVolunteerID = databaseHandler.addVolunteer(firstname, lastname, dob, email, address, city, state, zipcode, phone, occupation, employer, volunteerGender, license);

           /* We want to retrieve the volunteer ID and skill ID and enter it into the skill_index table */
            databaseHandler.addToSkillIndex(selectedSkillID,newestVolunteerID);



        });

    }


}
