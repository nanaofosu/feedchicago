package app.controller;

import app.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSkillsController {
    @FXML
    private TextField addSkillsViewName;

    @FXML
    private TextArea addSkillsViewDescription;

    @FXML
    private Button addSkillsViewSaveButton;

    @FXML
    private Button addSkillsViewCancelButton;

    @FXML
    void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        // initially set the text to null.
        addSkillsViewName.setText("");
        addSkillsViewDescription.setText("");

        addSkillsViewSaveButton.setOnAction(event -> {
            String skillName = addSkillsViewName.getText();
            String skillDescription = addSkillsViewDescription.getText();
            System.out.println(skillName +", "+ skillDescription);
            databaseHandler.addSkill(skillName, skillDescription);
            //close the screen
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        });

        addSkillsViewCancelButton.setOnAction(event -> {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        });


    }
}
