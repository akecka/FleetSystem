package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class LoginScreenController {

    private MainContainerController mainContainerController;

    public void setMainContainerController(MainContainerController mainContainerController) {
        this.mainContainerController = mainContainerController;
    }

    @FXML
    private TextField loginInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Label errorLabel;


    public void login() {

        if (validate()) {

            System.out.println(loginInput.getText());
            System.out.println(passwordInput.getText());

            //przejdz do pierwszej strony po zalogowaniu
            //WelcomeScreen
        }

    }

    public void register() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/fxml/RegisterScreen.fxml"));

        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.out.println("Blad podczas ladowania login screen");
        }

        RegisterScreenController registerScreenController = loader.getController();
        registerScreenController.setMainContainerController(this.mainContainerController);
        mainContainerController.setStackPane(pane);

    }

    public void exit() {

        Platform.exit();
    }

    private boolean validate() {

        errorLabel.setText("");

        if (loginInput.getText().isEmpty()) {
            errorLabel.setText("Pole loginu jest puste");
            return false;
        }

        if (passwordInput.getText().isEmpty()) {
            errorLabel.setText("Pole hasla jest puste");
            return false;

        }
        return true;
    }

}
