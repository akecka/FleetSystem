package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainContainerController {

    @FXML
    private StackPane stackPane;

    public void initialize() {
        openLoginScreen();
    }

    public void openLoginScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/fxml/LoginScreen.fxml"));

        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.out.println("Blad podczas ladowania login screen");
        }

        LoginScreenController loginScreenController = loader.getController();
        loginScreenController.setMainContainerController(this);
        setStackPane(pane);
    }

    public void setStackPane(Pane pane) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(pane);
    }

}
