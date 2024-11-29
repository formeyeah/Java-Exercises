package inClassexample.day8;

import java.util.Base64;

public class encodeDecodingExample {

	public static void main(String[] args) {
		byte[] byteArray= {10,20,40,10};
		String encoded=Base64.getEncoder().encodeToString(byteArray);
		System.out.println(encoded);
		
		byte[] decodebyte=Base64.getDecoder().decode(encoded);
		System.out.println(decodebyte);
		for (byte b : decodebyte) {
			System.out.println(b);
		}

	}

}
