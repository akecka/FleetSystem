package utils.validation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordValidatorTest {

    private static final String TOO_SHORT = "Haslo jest zbyt krotkie";
    private static final String TOO_LONG = "Haslo jest zbyt dlugie";
    private static final String EMPTY = "";

    @Test
    public void should_validate() {
        //Given
        String password = "password";
        //When
        ValidationResult validationResult = PasswordValidator.validatePassword(password);
        //Then
        assertEquals(true, validationResult.isValid());
        assertEquals(EMPTY, validationResult.getMessage());
    }

    @Test
    public void should_return_TooLong() {
        //Given
        String password = "passwordpasswordpassword";
        //When
        ValidationResult validationResult = PasswordValidator.validatePassword(password);
        //Then
        assertEquals(false, validationResult.isValid());
        assertEquals(TOO_LONG, validationResult.getMessage());
    }

    @Test
    public void should_return_TooShort() {
        //Given
        String password = "pass";
        //When
        ValidationResult validationResult = PasswordValidator.validatePassword(password);
        //Then
        assertEquals(false, validationResult.isValid());
        assertEquals(TOO_SHORT, validationResult.getMessage());
    }

}
