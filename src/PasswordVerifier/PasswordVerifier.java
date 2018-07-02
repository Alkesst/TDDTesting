package PasswordVerifier;

public class PasswordVerifier {

    boolean verify(String password){
        if (password == null)
            throw new PasswordVerifierException("Password should not be null");
            if (password.length() < 8)
                throw new PasswordVerifierException("The password is not longer tan 8 characters");
            if (!passwordContainsADigitALowerCaseAndAnUpperCaseLetter(password))
                throw new PasswordVerifierException(
                        "Password needs at least one digit, one upper case and one lower case letter"
                );
        return true;
    }

    private boolean passwordContainsADigitALowerCaseAndAnUpperCaseLetter(String password){
        boolean containsAtLeastOneUpperCaseLetter = false;
        boolean containsAtLeastOneLowerCaseLetter = false;
        boolean containsAtLeastOneDigit = false;
        int i = 0;
        while(i < password.length()){
            if (Character.isUpperCase(password.charAt(i))) containsAtLeastOneUpperCaseLetter = true;
            if (Character.isLowerCase(password.charAt(i))) containsAtLeastOneLowerCaseLetter = true;
            if (Character.isDigit(password.charAt(i))) containsAtLeastOneDigit = true;
            i++;
        }
        return containsAtLeastOneUpperCaseLetter && containsAtLeastOneLowerCaseLetter && containsAtLeastOneDigit;
    }

    public static void main(String[] args) {
        PasswordVerifier passwordVerifier = new PasswordVerifier();
        System.out.println(passwordVerifier.passwordContainsADigitALowerCaseAndAnUpperCaseLetter("NowItIsAValid3Password;)"));
    }
}
