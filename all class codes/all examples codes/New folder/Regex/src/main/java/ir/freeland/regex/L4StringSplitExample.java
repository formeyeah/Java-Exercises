package ir.freeland.regex;

public class L4StringSplitExample {
    public static void main(String[] args) {
        String input = "apple,banana,orange,grape";
        String regex = ","; // Split by comma

        String[] fruits = input.split(regex);
        for (String fruit : fruits) {
            System.out.println(fruit.trim()); // Trim to remove any leading/trailing spaces
        }
    }
}