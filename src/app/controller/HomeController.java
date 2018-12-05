package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button addSkillButton;

    @FXML
    private Button addVolunteerButton;

    @FXML
    private Button viewSkillsButton;

    @FXML
    private Button viewVolunteersButton;

    @FXML
    private Button logoutButton;

    private String ADD_SKILL_SCENE = "/app/view/addSkillsView.fxml";
    private String ADD_VOLUNTEER_SCENE = "/app/view/addVolunteerView.fxml";
    private String LOGOUT_SCENE = "/app/view/loginView.fxml";

    @FXML
    public void initialize() {

        addSkillButton.setOnAction(event -> {
            addSkillButton.getScene().getWindow().hide();
            homerouter(ADD_SKILL_SCENE);
        });

        addVolunteerButton.setOnAction(event -> {
            addSkillButton.getScene().getWindow().hide();
            homerouter(ADD_VOLUNTEER_SCENE);
        });

        viewSkillsButton.setOnAction(event -> {
            addSkillButton.getScene().getWindow().hide();
            homerouter(ADD_SKILL_SCENE);
        });

        viewVolunteersButton.setOnAction(event -> {
            addSkillButton.getScene().getWindow().hide();
            homerouter(ADD_SKILL_SCENE);
        });

        logoutButton.setOnAction(event -> {
            addSkillButton.getScene().getWindow().hide();
            homerouter(LOGOUT_SCENE);
        });

    }

    public void homerouter(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root  = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }




}
