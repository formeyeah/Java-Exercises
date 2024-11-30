package ir.freeland.security.messagedigest;
import java.security.SecureRandom;
import org.bouncycastle.crypto.generators.SCrypt;

import java.util.Base64;
/**
 * you want some algorithms SCrypt which is not in java core bouncycastle can
 * help https://www.bouncycastle.org/
 * https://www.bouncycastle.org/documentation/specification_interoperability/
 * 
 * BouncyCastle has FIPS (Federal Information Processing Standards). FIPS 140-2
 * and FIPS 140-3 are widely referenced standards that define the security
 * requirements for cryptographic modules.
 */
public class MessageDigestWithBouncyCastle {
	public static void main(String[] args) {
		String password = "mySecurePassword";

		// Generate a secure random salt
		byte[] salt = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);

		// SCrypt parameters
		int N = 16384; // CPU/memory cost
		int r = 8; // Block size
		int p = 1; // Parallelization factor
		int dkLen = 32; // Length of the derived key in bytes

		// Hash the password using SCrypt
		byte[] hashedPassword = SCrypt.generate(password.getBytes(), salt, N, r, p, dkLen);

		// Encode the salt and hashed password to Base64 for storage
		String saltBase64 = Base64.getEncoder().encodeToString(salt);
		String hashedPasswordBase64 = Base64.getEncoder().encodeToString(hashedPassword);

		System.out.println("Salt (Base64): " + saltBase64);
		System.out.println("Hashed Password (Base64): " + hashedPasswordBase64);

		// To verify the password, we need to hash it again with the same salt
		String inputPassword = "mySecurePassword"; // Password to verify
		byte[] hashedInputPassword = SCrypt.generate(inputPassword.getBytes(),salt, N, r, p, dkLen);

		// Compare the hashed passwords
		String hashedInputPasswordBase64 = Base64.getEncoder().encodeToString(hashedInputPassword);
		if (hashedInputPasswordBase64.equals(hashedPasswordBase64)) {
			System.out.println("Password matches!");
		} else {
			System.out.println("Password does not match.");
		}
	}
}