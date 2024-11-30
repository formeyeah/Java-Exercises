package ir.freeland.security.messagedigest;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * PBKDF2, BCrypt, and SCrypt are three recommended algorithms because: 
 * 1- we can slow down the algorithm 
 * 2- It accept size
 */
public class MessageDigestPBKDF2 {

	// Constants
	private static final int ITERATIONS = 10000; // Number of iterations
	private static final int KEY_LENGTH = 256; // Key length in bits
	private static final int SALT_LENGTH = 16; // Salt length in bytes

	public static void main(String[] args) throws Exception {
	
		String password = "mySecurePassword";

		// Generate a salt
		byte[] salt = generateSalt();

		// Hash the password
		String hashedPassword = hashPassword(password, salt);
		System.out.println(	"Salt: " + Base64.getEncoder().encodeToString(salt));
		System.out.println("Hashed Password: " + hashedPassword);

		// Verify the password
		boolean isVerified = verifyPassword(password, hashedPassword, salt);
		System.out.println("Password verified: " + isVerified);

	}
	// Method to generate a random salt
	private static byte[] generateSalt() {
		byte[] salt = new byte[SALT_LENGTH];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		return salt;
	}

	// Method to hash a password using PBKDF2
	public static String hashPassword(String password, byte[] salt)	throws Exception {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt,	ITERATIONS, KEY_LENGTH);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = factory.generateSecret(spec).getEncoded();
		return Base64.getEncoder().encodeToString(hash);
	}

	// Method to verify a password against a stored hash
	public static boolean verifyPassword(String password, String storedHash,byte[] salt) throws Exception {
		String hashToVerify = hashPassword(password, salt);
		return hashToVerify.equals(storedHash);
	}
}