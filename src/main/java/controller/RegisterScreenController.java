package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.validation.PasswordValidator;
import utils.validation.ValidationResult;

public class RegisterScreenController {

    private MainContainerController mainContainerController;

    public void setMainContainerController(MainContainerController mainContainerController) {
        this.mainContainerController = mainContainerController;
    }

    private static final String EMPTY_INPUT = "Pole musi zostac wypelnione";

    @FXML
    private TextField loginInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField surnameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField repeatPasswordInput;

    @FXML
    private TextField emailInput;

    @FXML
    private Label errorLogin;

    @FXML
    private Label errorName;

    @FXML
    private Label errorSurname;

    @FXML
    private Label errorPassword;

    @FXML
    private Label errorRepeatPassword;

    @FXML
    private Label errorEmail;

    public void register() {

        if (validate()) {
            System.out.println("tekst");
        }

    }

    public void back() {
        mainContainerController.openLoginScreen();
    }

    public boolean validate() {

        boolean result = true;

        if (loginInput.getText().isEmpty()) {
            errorLogin.setText(EMPTY_INPUT);
            result = false;
        }

        if (nameInput.getText().isEmpty()) {
            errorName.setText(EMPTY_INPUT);
            result = false;
        }

        if (surnameInput.getText().isEmpty()) {
            errorSurname.setText(EMPTY_INPUT);
            result = false;
        }

        if (passwordInput.getText().isEmpty()) {
            errorPassword.setText(EMPTY_INPUT);
            result = false;
        } else {
            ValidationResult validationPwResult = PasswordValidator.validatePassword(passwordInput.getText());
            if (!validationPwResult.isValid()) {
                errorPassword.setText(validationPwResult.getMessage());
                result = false;
            }
        }

        if (repeatPasswordInput.getText().isEmpty()) {
            errorRepeatPassword.setText(EMPTY_INPUT);
            result = false;
        } else {
            ValidationResult validationRepPwResult = PasswordValidator.validatePassword(repeatPasswordInput.getText());
            if (!validationRepPwResult.isValid()) {
                errorRepeatPassword.setText(validationRepPwResult.getMessage());
                result = false;
            }

            if (!repeatPasswordInput.getText().equals(passwordInput.getText())){
                errorRepeatPassword.setText("Haslo jest nieprawidlowe");
                result = false;
            }
        }

        if (emailInput.getText().isEmpty()) {
            errorEmail.setText(EMPTY_INPUT);
            result = false;
        }

        return result;
    }
}