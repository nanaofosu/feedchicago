package app.controller;

import app.database.DatabaseHandler;
import app.model.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListSkillsController {

    @FXML
    private TableView<Skill> table;

    @FXML
    private TableColumn<Skill, String> skillCol;

    @FXML
    private TableColumn<Skill, String> descriptionCol;

    ObservableList<Skill> skillsList = FXCollections.observableArrayList();

    public void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String sql = "SELECT skillname, skillDescription FROM skill";

        try {
            ResultSet rs = databaseHandler.getDbConnection().createStatement().executeQuery(sql);
            while(rs.next()){
                skillsList.add(new Skill(
                        rs.getString("skillname"),
                        rs.getString("skillDescription")

                ));

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e)  {
            e.printStackTrace();
        }

        //set the values of the colums
        skillCol.setCellValueFactory(new PropertyValueFactory<>("skillname"));


        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("skillDescription"));

        table.setItems(skillsList);
        table.setEditable(true);

        try {
            databaseHandler.getDbConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }

}
