package ir.freeland.security.encryptiondecryption;

import javax.crypto.Cipher;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

/**
 * you can use a predefined key string for AES encryption and decryption in
 * Java. However, it’s important to ensure that the key size matches the
 * requirements of the AES algorithm, which can be 128, 192, or 256 bits.
 * 
 * There are some issues, for example for AES the key must be 16 characters or
 * you will see errors
 * 
 */
public class PredefinedSymmetricKeyEncryptionExample {
	public static void main(String[] args) throws Exception {
			// Step 1: Define a predefined key (must be 16 bytes for AES-128)
			String keyString = "MYSECRTKEY123456"; // 16 characters for AES-128
			SecretKeySpec secretKey = new SecretKeySpec(keyString.getBytes(),
					"AES");

			// Step 2: Encrypt a message using the predefined key
			String originalMessage = "Hello, this is a secret message!";
			String encryptedMessage = encrypt(originalMessage, secretKey);
			System.out.println("Encrypted Message: " + encryptedMessage);

			// Step 3: Decrypt the message using the same predefined key
			String decryptedMessage = decrypt(encryptedMessage, secretKey);
			System.out.println("Decrypted Message: " + decryptedMessage);

		
	}

	// Method to encrypt a message using AES
	private static String encrypt(String message, SecretKeySpec secretKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(message.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	// Method to decrypt a message using AES
	private static String decrypt(String encryptedMessage,
			SecretKeySpec secretKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher
				.doFinal(Base64.getDecoder().decode(encryptedMessage));
		return new String(decryptedBytes);
	}
}