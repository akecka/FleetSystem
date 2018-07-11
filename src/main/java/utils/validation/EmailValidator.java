package utils.validation;

public class EmailValidator {

    private static final String TOO_SHORT = "Email jest zbyt krotki";
    private static final String TOO_LONG = "Email jest zbyt dlugi";


    public static ValidationResult validateEmail(final String email) {

        boolean isValid = true;
        String message = "";

        if (email.length() < 6) {
            isValid = false;
            message = TOO_SHORT;
        }

        if (email.length() > 30) {
            isValid = false;
            message = TOO_LONG;

        }

        return new ValidationResult(isValid, message);
    }

}