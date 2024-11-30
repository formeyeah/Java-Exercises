
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecurityUtils {
	private static final Logger log = Logger.getLogger(SecurityUtils.class.getName());
    private static final String KEYSTORE_TYPE = "JCEKS"; // Use JCEKS for storing secret keys
    private static final String KEYSTORE_FILE = "isckeystore.jceks";
    private static final String KEYSTORE_PASSWORD = "changeit"; // Change this to a secure password
    private static final String SECRET_KEY_ALIAS = "mySecretKey";

    
	public static SecretKey generateKey() throws GeneralSecurityException {		
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");		
		SecretKey secretKey = keyGen.generateKey(); 
		log.info( "The key value is made as: " + Base64.getEncoder().encodeToString ( secretKey.getEncoded()) );
		return secretKey;
	}
	
	public static String encrypt(String message, SecretKey secretKey) 
			throws GeneralSecurityException  {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(message.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	

	
	public static KeyPair generateKeypair() throws GeneralSecurityException {	
		// Generate a Key Pair (public/private)
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
		KeyPair keyPair = keyPairGen.generateKeyPair();
		
		log.info( "The private key value was made: " + Base64.getEncoder().encodeToString ( keyPair.getPrivate().getEncoded()) );
		log.info( "The public key value was made: " + Base64.getEncoder().encodeToString ( keyPair.getPublic().getEncoded()) );
		return keyPair;
	}
	
	public static String sign(String message ,PrivateKey privateKey) throws GeneralSecurityException {	
		Signature signature = Signature.getInstance("SHA256withDSA");
		signature.initSign(privateKey);
		signature.update(message.getBytes());
		byte[] digitalSignature = signature.sign();
		return Base64.getEncoder().encodeToString(digitalSignature);
	}

  
    public static void saveKeyToKeyStore(SecretKey secretKey) throws  KeyStoreException, GeneralSecurityException, IOException  {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        keyStore.load(null, KEYSTORE_PASSWORD.toCharArray()); // Create a new empty KeyStore

        // Store the secret key in the KeyStore
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(KEYSTORE_PASSWORD.toCharArray());
        keyStore.setEntry(SECRET_KEY_ALIAS, secretKeyEntry, protectionParam);

        // Save the KeyStore to a file
        try (FileOutputStream keyStoreOutputStream = new FileOutputStream(KEYSTORE_FILE)) {
            keyStore.store(keyStoreOutputStream, KEYSTORE_PASSWORD.toCharArray());
        }
    }
}
