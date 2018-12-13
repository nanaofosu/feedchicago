package app.controller;

import app.database.DatabaseHandler;
import app.model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

import static app.database.Const.*;

public class ListVolunteersController {

    @FXML
    private Button file_cancel;

    @FXML
    private TableView<Volunteer> table;

    @FXML
    private TableColumn<Volunteer, String> firstnameCol;

    @FXML
    private TableColumn<Volunteer, String> lastnameCol;

    @FXML
    private TableColumn<Volunteer, String> dobCol;

    @FXML
    private TableColumn<Volunteer, String> genderCol;

    @FXML
    private TableColumn<Volunteer, String> addressCol;

    @FXML
    private TableColumn<Volunteer, String> cityCol;

    @FXML
    private TableColumn<Volunteer, String> stateCol;

    @FXML
    private TableColumn<Volunteer, String> ziocodeCol;

    @FXML
    private TableColumn<Volunteer, String> phoneCol;

    @FXML
    private TableColumn<Volunteer, String> occupationCol;

    @FXML
    private TableColumn<Volunteer, String> employerCol;

    @FXML
    private TableColumn<Volunteer, String> licenseCol;

    @FXML
    private TableColumn<Volunteer, String> emailCol;

    @FXML
    private TableColumn<Volunteer, String> skillCol;

    ObservableList<Volunteer> volunteersList = FXCollections.observableArrayList();

    public void initialize()  {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String sql = "SELECT " +
                "volunteer.firstname, " +
                "volunteer.lastname, " +
                "volunteer.dob, " +
                "volunteer.gender, " +
                "volunteer.email, " +
                "volunteer.address, " +
                "volunteer.city, " +
                "volunteer.state, " +
                "volunteer.zipcode, " +
                "volunteer.phone, " +
                "volunteer.occupation, " +
                "volunteer.employer, " +
                "volunteer.license,  " +
                "skill.skillname, " +
                "skill_index.skillIndexID " +
                "FROM volunteer, skill, skill_index where skill_index.skillID = skill.skillID and volunteer.volunteerID = skill_index.volunteerID;";

        try {
            ResultSet rs = databaseHandler.getDbConnection().createStatement().executeQuery(sql);
            while(rs.next()){
                volunteersList.add(
                        new Volunteer(
                        rs.getString(VOLUNTEER_FIRSTNAME),
                        rs.getString(VOLUNTEER_LASTNAME),
                        rs.getString(VOLUNTEER_DOB),
                        rs.getString(VOLUNTEER_GENDER),
                        rs.getString(VOLUNTEER_EMAIL),
                        rs.getString(VOLUNTEER_ADDRESS),
                        rs.getString(VOLUNTEER_CITY),
                        rs.getString(VOLUNTEER_STATE),
                        rs.getString(VOLUNTEER_ZIPCODE),
                        rs.getString(VOLUNTEER_PHONE),
                        rs.getString(VOLUNTEER_OCCUPATION),
                        rs.getString(VOLUNTEER_EMPLOYER),
                        rs.getString(VOLUNTEER_LICENSE),
                        rs.getString("skillname")
                        ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e)  {
            e.printStackTrace();
        }

        //set the values of the colums
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_FIRSTNAME));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_LASTNAME));
        dobCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_DOB));
        genderCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_GENDER));
        emailCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_EMAIL));
        addressCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_ADDRESS));
        cityCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_CITY));
        stateCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_STATE));
        ziocodeCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_ZIPCODE));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_PHONE));
        occupationCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_OCCUPATION));
        employerCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_EMPLOYER));
        licenseCol.setCellValueFactory(new PropertyValueFactory<>(VOLUNTEER_LICENSE));
        skillCol.setCellValueFactory(new PropertyValueFactory<>("skillname"));


        table.setItems(volunteersList);

        try {
            databaseHandler.getDbConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        file_cancel.setOnAction(event -> {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        });
    }

}
