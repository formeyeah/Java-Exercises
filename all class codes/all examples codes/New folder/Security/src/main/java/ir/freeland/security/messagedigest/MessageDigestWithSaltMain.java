package ir.freeland.security.messagedigest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class MessageDigestWithSaltMain {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// The input string to be hashed
		String input = "Hello, World!";

		// Generate a random salt
		byte[] salt = generateSalt(16); // 16 bytes salt

		// Create a MessageDigest instance for SHA-256
		MessageDigest digest = MessageDigest.getInstance("SHA-256");

		// Combine the salt and the input
		digest.update(salt);
		byte[] hashBytes = digest.digest(input.getBytes());

		// Encode the salt and the hash to Base64
		String base64Salt = Base64.getEncoder().encodeToString(salt);
		String base64Hash = Base64.getEncoder().encodeToString(hashBytes);

		// Print the resulting salt and hash
		System.out.println("Input: " + input);
		System.out.println("Salt (Base64): " + base64Salt);
		System.out.println("SHA-256 Hash (Base64): " + base64Hash);

	}

	// Method to generate a random salt
	private static byte[] generateSalt(int length) {
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[length];
		secureRandom.nextBytes(salt);
		return salt;
	}
}

/**
 * See https://en.wikipedia.org/wiki/Secure_Hash_Algorithms Comparison collision
 * attacks and length extension attacks
 * 
 */