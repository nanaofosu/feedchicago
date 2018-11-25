package app.controller;

import app.database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddSkillsController {
    @FXML
    private TextField addSkillsViewName;

    @FXML
    private TextArea addSkillsViewDescription;

    @FXML
    private Button addSkillsViewSaveButton;

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

        });


    }
}
