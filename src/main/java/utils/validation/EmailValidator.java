package utils.validation;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidator {

    private static final String TOO_SHORT = "Email jest zbyt krotki";
    private static final String TOO_LONG = "Email jest zbyt dlugi";
    private static final String WRONG_EMAIL = "Email ma niepoprawna skladnie";


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

        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            isValid = false;
            message = WRONG_EMAIL;
        }

        return new ValidationResult(isValid, message);
    }

}