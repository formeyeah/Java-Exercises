package ir.freeland.regex;

public class L7ReDoS2 {
    public static void main(String[] args) {
        String username = "alireza"; //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!";
        String password = "alireza"; //"(.*a){10000}";

        System.out.println( isUsernameAndPasswordSame(username,password) );
        
    }
    
    private static boolean isUsernameAndPasswordSame(String username, String password) {
    	return username.matches(password);
    }
}