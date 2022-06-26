package com.cg.untils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NUMBER_REGEX = "\\d+";
    public static final String USERNAME_REGEX = "^[a-z0-9_-]{3,16}$";

    private static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";

    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";

    public static boolean isNumberValid(String number) {
        return Pattern.compile(NUMBER_REGEX).matcher(number).matches();
    }
    public static boolean isUsernameValid(String username) {
        return Pattern.compile(USERNAME_REGEX).matcher(username).matches();
    }
    public static boolean isPhoneValid(String phone){
        return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
    }
    public static boolean isPasswordvalid(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }


}
