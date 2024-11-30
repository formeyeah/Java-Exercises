package ir.freeland.security.keygen;
import java.security.*;
import javax.crypto.KeyAgreement;
import java.util.Base64;

/**
 * DH solves secure one-to-one communication (via both parties privately
 * calculating "half" of the shared secret), while RSA solves secure one-to-many
 * communication (via one party distributing "half" of the secret to any other
 * parties that need it)
 */
public class DiffieHellmanKeyGen {
	public static void main(String[] args) {
		try {
			// Step 1: Generate a Diffie-Hellman key pair for both parties
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DH");
			keyPairGen.initialize(2048); // Key size
			KeyPair keyPairA = keyPairGen.generateKeyPair();
			KeyPair keyPairB = keyPairGen.generateKeyPair();

			// Step 2: Generate the shared secret for both parties
			KeyAgreement keyAgreementA = KeyAgreement.getInstance("DH");
			keyAgreementA.init(keyPairA.getPrivate());
			keyAgreementA.doPhase(keyPairB.getPublic(), true);
			byte[] sharedSecretA = keyAgreementA.generateSecret();

			KeyAgreement keyAgreementB = KeyAgreement.getInstance("DH");
			keyAgreementB.init(keyPairB.getPrivate());
			keyAgreementB.doPhase(keyPairA.getPublic(), true);
			byte[] sharedSecretB = keyAgreementB.generateSecret();

			// Step 3: Encode the shared secret in Base64
			String base64SharedSecretA = Base64.getEncoder().encodeToString(sharedSecretA);
			String base64SharedSecretB = Base64.getEncoder().encodeToString(sharedSecretB);

			// Step 4: Print the Base64 encoded shared secret
			System.out.println("Base64 Shared Secret A: " + base64SharedSecretA);
			System.out.println("Base64 Shared Secret B: " + base64SharedSecretB);

			// Verify that both shared secrets are the same
			if (MessageDigest.isEqual(sharedSecretA, sharedSecretB)) {
				System.out.println("Shared secrets match!");
			} else {
				System.out.println("Shared secrets do not match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}