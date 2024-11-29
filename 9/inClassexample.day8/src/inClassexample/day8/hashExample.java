package inClassexample.day8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class hashExample {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String text="hello hash me pls";
		MessageDigest digest=MessageDigest.getInstance("MD5");
		byte[] bytearray=digest.digest(text.getBytes());
		String encoded=Base64.getEncoder().encodeToString(bytearray);
		System.out.println(encoded);

	}

}
