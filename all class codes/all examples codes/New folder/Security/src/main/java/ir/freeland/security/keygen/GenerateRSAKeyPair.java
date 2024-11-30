package ir.freeland.security.keygen;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateRSAKeyPair {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// Create a KeyPairGenerator for RSA
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048); // Specify the key size

		// Generate the key pair
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// Encode the keys in Base64
		String publicKeyEncoded = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		String privateKeyEncoded = Base64.getEncoder().encodeToString(privateKey.getEncoded());

		// Print the keys in PEM format
		System.out.println("-----BEGIN PUBLIC KEY-----");
		System.out.println(publicKeyEncoded.length());
		System.out.println("-----END PUBLIC KEY-----");

		System.out.println("\n\n-----BEGIN PRIVATE KEY-----");
		System.out.println(privateKeyEncoded.length());
		System.out.println("-----END PRIVATE KEY-----");

	}
}