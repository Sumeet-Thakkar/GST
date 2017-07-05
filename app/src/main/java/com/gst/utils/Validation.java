package com.gst.utils;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Validation {

    //  public static final String INVALID_EMAIL = "Please enter valid email address.";

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isRequiredField(String strText) {
        return strText != null && !strText.trim().isEmpty();
    }

    public static String getString(String strText) {

        if (isRequiredField(strText)) {
            try {
                return strText;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";

    }

    public static int getIntFromString(String strText) {

        if (isRequiredField(strText)) {
            try {
                return Integer.parseInt(strText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;

    }

    public static double getDoubleFromString(String strText) {

        if (isRequiredField(strText)) {
            try {
                return Double.parseDouble(strText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;

    }


    public static float getFloatFromString(String strText) {

        if (isRequiredField(strText)) {
            try {
                return Float.parseFloat(strText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;

    }


    public static boolean isEmail(String strEmailAddress) {
        return Pattern.compile(EMAIL_PATTERN).matcher(strEmailAddress).matches();
//        return Patterns.EMAIL_ADDRESS.matcher(strEmailAddress).matches();
    }

    public static boolean isAlphabetic(String strText) {
        return strText.matches("[a-zA-Z ]+");
    }

    public static boolean isMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public static boolean isCardNumber(String cardno) {
        return isRequiredField(cardno) && (cardno.length() == 16);
    }

    public static boolean isCVCcode(String cvc){
        return isRequiredField(cvc) && (cvc.length() == 3 || cvc.length() == 4);
    }

    public static boolean isWebUrl(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    public static boolean isPhoneNo(String phoneNo) {
        return Patterns.PHONE.matcher(phoneNo).matches();
    }


    public static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

}
