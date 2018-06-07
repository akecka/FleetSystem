package utils.validation;

public class PasswordValidator {

    private static final String TOO_SHORT = "Haslo jest zbyt krotkie";
    private static final String TOO_LONG = "Haslo jest zbyt dlugie";

    public static ValidationResult validatePassword(String password) {

        boolean isValid = true;
        String message = "";

        if (password.length() < 6) {
            isValid = false;
            message = TOO_SHORT;
        }

        if (password.length() > 18) {
            isValid = false;
            message = TOO_LONG;
        }

        return new ValidationResult(isValid, message);
    }

}
