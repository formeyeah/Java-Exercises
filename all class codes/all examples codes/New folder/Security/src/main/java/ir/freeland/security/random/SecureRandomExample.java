package ir.freeland.security.random;

import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomExample {
	public static void main(String[] args) {
		// Create a SecureRandom instance
		SecureRandom secureRandom = new SecureRandom();

		// Generate random bytes
		byte[] randomBytes = new byte[16]; // 16 bytes
		secureRandom.nextBytes(randomBytes); // Fill the array with random bytes

		// Generate a random integer
		int randomInt = secureRandom.nextInt(100); // Random integer between 0
													// and 99

		// Generate a random long
		long randomLong = secureRandom.nextLong(); // Random long value

		// Print the generated random values
		System.out.println("Random Bytes (Base64): " + Base64.getEncoder().encodeToString(randomBytes));
		System.out.println("Random Integer (0-99): " + randomInt);
		System.out.println("Random Long: " + randomLong);
	}
}

/**
 * Gathers entropy from various sources: System hardware noise. Timing of events
 * (e.g., CPU cycles, disk I/O). User interactions (e.g., mouse movements,
 * keystrokes).
 * 
 * SecureRandom can periodically reseed itself using new entropy
 * 
 */
