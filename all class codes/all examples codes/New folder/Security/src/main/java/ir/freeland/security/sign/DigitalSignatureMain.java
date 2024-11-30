package ir.freeland.security.sign;

import java.security.*;
import java.util.Base64;

public class DigitalSignatureMain {
	public static void main(String[] args) throws Exception {
		
			// Generate a Key Pair (public/private)
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(2048); // Key size
			KeyPair keyPair = keyPairGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();

			// Message to be signed
			String message = "This is a secret message.";

			// Create a Signature object and initialize it with the private key
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(privateKey);
			signature.update(message.getBytes());

			// Sign the message
			byte[] digitalSignature = signature.sign();
			String signatureBase64 = Base64.getEncoder().encodeToString(digitalSignature);
			System.out.println("Digital Signature (Base64): " + signatureBase64);

			// Now, let's verify the signature
			Signature signatureVerify = Signature.getInstance("SHA256withRSA");
			signatureVerify.initVerify(publicKey);
			signatureVerify.update(message.getBytes());

			// Verify the signature
			boolean isVerified = signatureVerify.verify(digitalSignature);
			System.out.println("Signature Verified: " + isVerified);
	
	}
}