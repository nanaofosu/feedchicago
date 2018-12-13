package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private String VIEW_VOLUNTEERS_SCENE = "/app/view/listVolunteersView.fxml";
    private String VIEW_SKILLS_SCENE = "/app/view/listSkillView.fxml";

    @FXML
    public void initialize() {

        addSkillButton.setOnAction(event -> {
            homerouter(ADD_SKILL_SCENE, "Add a skill.");
        });

        addVolunteerButton.setOnAction(event -> {
            homerouter(ADD_VOLUNTEER_SCENE, "Add a Volunteer.");
        });

        viewSkillsButton.setOnAction(event -> {
            homerouter(VIEW_SKILLS_SCENE, "View all skills.");
        });

        viewVolunteersButton.setOnAction(event -> {
            homerouter(VIEW_VOLUNTEERS_SCENE, "View all volunteers");

        });

        logoutButton.setOnAction(event -> {
            homerouter(LOGOUT_SCENE, "Feed Chicago App");
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        });

    }


    /*  OPEN A NEW WINDOW SO WE DON"T RUN OUT OF MEMORY */
    public void homerouter(String path, String title) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("Cant show new window");
        }
    }




}
