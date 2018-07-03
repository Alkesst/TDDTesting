package PasswordVerifier;

public class PasswordVerifierException extends RuntimeException{
    public PasswordVerifierException() {
    }

    public PasswordVerifierException(String message) {
        super(message);
    }
}
