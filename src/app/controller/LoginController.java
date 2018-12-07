package app.controller;

import app.assets.StringAssets;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements StringAssets{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loginViewErrorMessage;

    @FXML
    private TextField loginViewUsername;

    @FXML
    private PasswordField loginViewPassword;

    @FXML
    private Button loginViewLoginButton;

    @FXML
    void initialize() {
        loginViewErrorMessage.setText("");



        loginViewLoginButton.setOnAction(event -> {
            String username = loginViewUsername.getText().trim();
            String password = loginViewPassword.getText().trim();

            if(username.equals("")){
                loginViewErrorMessage.setText(USERNAME_EMPTY);
                loginViewErrorMessage.setTextFill(Paint.valueOf("#000000"));
            }
            else {
                loginUser(username,password);
            }

        });
    }

    private void loginUser(String username, String password) {
        //check the db if the user exists. if true we take them to add next screen
        loginViewLoginButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/app/view/homeView.fxml"));
//        loader.setLocation(Main.class.getResource("/app/view/homeView.fxml"));
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
