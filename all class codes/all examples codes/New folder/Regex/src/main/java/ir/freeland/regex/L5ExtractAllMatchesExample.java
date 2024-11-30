package ir.freeland.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class L5ExtractAllMatchesExample {
    public static void main(String[] args) {
        String text = "The rain in Spain stays mainly in the plain.";
        String regex = "\\w*ain"; // Match the word "ain"

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }
    }
}