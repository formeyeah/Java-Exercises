package ir.freeland.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class L1RegexExample {
    public static void main(String[] args) {
        String text = "Hello, my email is example@example.com";
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"; // Email regex [a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Found an email: " + matcher.group());
        } else {
            System.out.println("No email found.");
        }
    }
}