package ir.freeland.regex;

public class L3StringReplaceDigitsExample {
    public static void main(String[] args) {
        String input = "My phone number is 123-456-7890.";
        String regex = "\\d"; // Match any digit

        String result = input.replaceAll(regex, "#");
        System.out.println(result); // Output: My phone number is ###-###-####.
    }
}