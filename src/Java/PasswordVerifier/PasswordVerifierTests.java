package PasswordVerifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordVerifierTests {

    @Test
    void testThatIfThePasswordLengthIsLessThan8ThenThrowsAnException(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = "polla;)";
        String errorMessage = "the password is not longer tan 8 characters";
        PasswordVerifierException except =
                assertThrows(
                        PasswordVerifierException.class
                  , () -> passVer.verify(password)
                );
        assertEquals(errorMessage, except.getMessage().toLowerCase());
    }

    @Test
    void testAPasswordWhichIsValid(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = "PasswordWithLengthGreaterThan8";
        assertTrue(passVer.verify(password));
    }

    @Test
    void testIfAPasswordIsNullThenThrowsAPrettyException(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = null;
        String errorMessage = "password should not be null";
        PasswordVerifierException except = assertThrows(
            PasswordVerifierException.class,
                () -> passVer.verify(password)
        );
        assertEquals(errorMessage, except.getMessage().toLowerCase());
    }

    @Test
    void testThatThePasswordHasAtLeastOneUpperCaseLetter(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = "thisisnotavalidpassword";
        String errorMessage = "password needs at least one digit, one upper case and one lower case letter";
        PasswordVerifierException except = assertThrows(
                PasswordVerifierException.class,
                () -> passVer.verify(password)
        );
        assertEquals(errorMessage, except.getMessage().toLowerCase());
    }

    @Test
    void testThatIsAValidPasswordWithAnUpperCaseLetter(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = "NowItIsAValid3Password;)";
        assertTrue(passVer.verify(password));
    }

    @Test
    void testThatThePasswordHasAtLeastOneLowerCaseLetter(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = "THISISNOTAVALIDPASSWORD:(";
        String errorMessage = "password needs at least one digit, one upper case and one lower case letter";
        PasswordVerifierException except = assertThrows(
                PasswordVerifierException.class,
                () -> passVer.verify(password)
        );
        assertEquals(errorMessage, except.getMessage().toLowerCase());
    }

    @Test
    void testThatThePasswordHasAtLeastOneDigit(){
        PasswordVerifier passVer = new PasswordVerifier();
        String password = "this password has no digits";
        String errorMessage = "password needs at least one digit, one upper case and one lower case letter";
        PasswordVerifierException except = assertThrows(
                PasswordVerifierException.class,
                () -> passVer.verify(password)
        );
        assertEquals(errorMessage, except.getMessage().toLowerCase());
    }
}
