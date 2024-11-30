package ir.freeland.security.encryptiondecryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.util.Base64;

public class SymmetricKeyEncryptionExample {
	public static void main(String[] args) throws Exception {

			// Step 1: Generate a symmetric key for AES
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128); // Key size (128, 192, or 256 bits)
			SecretKey secretKey = keyGen.generateKey();

			// Step 2: Encrypt a message using the symmetric key
			String originalMessage = "Hello, this is a secret message!";
			String encryptedMessage = encrypt(originalMessage, secretKey);
			System.out.println("Encrypted Message: " + encryptedMessage);

			// Step 3: Decrypt the message using the same symmetric key
			String decryptedMessage = decrypt(encryptedMessage, secretKey);
			System.out.println("Decrypted Message: " + decryptedMessage);


	}

	// Method to encrypt a message using AES
	private static String encrypt(String message, SecretKey secretKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(message.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	// Method to decrypt a message using AES
	private static String decrypt(String encryptedMessage, SecretKey secretKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher
				.doFinal(Base64.getDecoder().decode(encryptedMessage));
		return new String(decryptedBytes);
	}
}