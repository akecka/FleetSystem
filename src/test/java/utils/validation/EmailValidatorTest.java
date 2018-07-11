package utils.validation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailValidatorTest {

    private static final String TOO_SHORT = "Email jest zbyt krotki";
    private static final String TOO_LONG = "Email jest zbyt dlugi";
    private static final String EMPTY = "";

    @Test
    public void should_validate() {
        //Given
        String email = "email@wp.pl";
        //When
        ValidationResult validationResult = EmailValidator.validateEmail(email);
        //Then
        assertEquals(true, validationResult.isValid());
        assertEquals(EMPTY, validationResult.getMessage());
    }

    @Test
    public void should_return_TooLong() {
        //Given
        String email = "emailemaileerterpkeoepgmepokepojepoj@wp.pl";
        //When
        ValidationResult validationResult = EmailValidator.validateEmail(email);
        //Then
        assertEquals(false, validationResult.isValid());
        assertEquals(TOO_LONG, validationResult.getMessage());
    }

    @Test
    public void should_return_TooShort() {
        //Given
        String email = "e@p.p";
        //When
        ValidationResult validationResult = EmailValidator.validateEmail(email);
        //Then
        assertEquals(false, validationResult.isValid());
        assertEquals(TOO_SHORT, validationResult.getMessage());

    }
}
