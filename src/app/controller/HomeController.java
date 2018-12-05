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

    @FXML
    public void initialize() {

        addSkillButton.setOnAction(event -> {
//            addSkillButton.getScene().getWindow().hide();
            homerouter(ADD_SKILL_SCENE);
        });

        addVolunteerButton.setOnAction(event -> {
//            addVolunteerButton.getScene().getWindow().hide();
            homerouter(ADD_VOLUNTEER_SCENE);
        });

        viewSkillsButton.setOnAction(event -> {
//            viewSkillsButton.getScene().getWindow().hide();
            homerouter(ADD_SKILL_SCENE);
        });

        viewVolunteersButton.setOnAction(event -> {
//            viewVolunteersButton.getScene().getWindow().hide();
            homerouter(VIEW_VOLUNTEERS_SCENE);


        });

        logoutButton.setOnAction(event -> {
//            logoutButton.getScene().getWindow().hide();
            homerouter(LOGOUT_SCENE);
        });

    }

    /*public void homerouter(String path) {
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
    }*/

    public void homerouter(String path) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("VIEW EM ALL");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("CAnt show new windo");
        }
    }




}
