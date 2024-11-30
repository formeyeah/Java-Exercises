package ir.freeland.security.messagedigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MessageDigestMain {
	public static void main(String[] args) throws NoSuchAlgorithmException {

		// The input string to be hashed
		String input = "password123";

		// Create a MessageDigest instance for SHA-256
		MessageDigest digest = MessageDigest.getInstance("MD5");

		// Perform the hashing
		byte[] hashBytes = digest.digest(input.getBytes());

		// Encode the byte array to Base64
		String base64Hash = Base64.getEncoder().encodeToString(hashBytes);

		// Convert the byte array to a hexadecimal string
		StringBuilder hexString = new StringBuilder();
		for (byte b : hashBytes) {
			String hex = Integer.toHexString(0xff & b); // Get the hex representation
			if (hex.length() == 1)
				hexString.append('0'); // Pad with leading zero if needed
			hexString.append(hex);
		}

		// Print the resulting hash
		System.out.println("Input: " + input);
		System.out.println("MD5 Hash (Base64): " + base64Hash);
		System.out.println("MD5 Hash (Hex): " + hexString.toString());

	}
}

/**
 * https://www.cs.usfca.edu/~galles/visualization/OpenHash.html see animation
 * Use https://crackstation.net/ 482c811da5d5b4bc6d497ffa98491e38 -> password123
 */
