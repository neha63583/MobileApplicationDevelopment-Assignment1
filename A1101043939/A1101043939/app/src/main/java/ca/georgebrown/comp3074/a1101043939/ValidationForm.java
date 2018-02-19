package ca.georgebrown.comp3074.a1101043939;

import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Student id: 101043939
 * Student Name: Neha Arora**/

public class ValidationForm {

    private static final String namePattern = "[a-zA-Z ]+";
    private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String contactPattern = "\\d{3}-\\d{7}";


    private static final String requiredFields = "Required";
    private static final String invalidName = "invalid name";
    private static final String invalidEmail = "invalid email";
    private static final String invalidContact = "invalid contact";




    public static boolean isName(EditText editText, boolean required) {
        return isValid(editText, namePattern, invalidName, required);
    }
    public static boolean isEmailAddress(EditText editText, boolean required) {
        return isValid(editText, emailPattern, invalidEmail, required);
    }

    public static boolean isContactNumber(EditText editText, boolean required) {
        return isValid(editText, contactPattern, invalidContact, required);
    }


    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if ( required && !hasText(editText) ) return false;

        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        return true;
    }

    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (text.length() == 0) {
            editText.setError(requiredFields);
            return false;
        }

        return true;
    }
}
