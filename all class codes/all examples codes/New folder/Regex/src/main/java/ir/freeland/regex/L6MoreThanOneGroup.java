package ir.freeland.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class L6MoreThanOneGroup {
    public static void main(String[] args) {
    	  String text = "The order id is 12-99333392";
          String regex = "(\\d+)-(\\d+)"; // Match the word "ain"

          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(text);

          while (matcher.find()) {
              System.out.println("Found: " + matcher.group(1) + " " + matcher.group(2));
          }
    }
}