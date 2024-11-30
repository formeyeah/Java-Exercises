package ir.freeland.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class L2PhoneNumberValidation {
    public static void main(String[] args) {
        String phoneNumber = "(123) 456-7890";
        String regex = "^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$"; // Phone number regex ^\(\d{3}\) \d{3}-\d{4}$|^\d{3}-\d{3}-\d{4}$

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("Valid phone number.");
        } else {
            System.out.println("Invalid phone number.");
        }
    }
}