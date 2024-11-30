package ir.freeland.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class L7ReDoS {
    public static void main(String[] args) {
        String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!";
        String regex = "(.*a){10000}"; // Email regex [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Valid : " + matcher.group());
        } else {
            System.out.println("Not valid");
        }
    }
}