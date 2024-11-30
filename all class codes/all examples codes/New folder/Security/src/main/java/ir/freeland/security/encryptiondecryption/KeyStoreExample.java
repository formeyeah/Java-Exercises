package ir.freeland.security.encryptiondecryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.util.Base64;

public class KeyStoreExample {
    private static final String KEYSTORE_TYPE = "JCEKS"; // Use JCEKS for storing secret keys
    private static final String KEYSTORE_FILE = "isckeystore.jceks";
    private static final String KEYSTORE_PASSWORD = "changeit"; // Change this to a secure password
    private static final String SECRET_KEY_ALIAS = "mySecretKey";

    public static void main(String[] args) throws Exception {
    	
        // Step 1: Generate a symmetric key for AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES-128
        SecretKey secretKey = keyGen.generateKey();

        // Step 2: Save the key to a KeyStore
        saveKeyToKeyStore(secretKey);

        // Step 3: Read the key back from the KeyStore
        SecretKey retrievedKey = getKeyFromKeyStore();

        // Step 4: Encrypt a message using the retrieved key
        String originalMessage = "Hello, this is a secret message!";
        String encryptedMessage = encrypt(originalMessage, retrievedKey);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Step 5: Decrypt the message using the retrieved key
        String decryptedMessage = decrypt(encryptedMessage, retrievedKey);
        System.out.println("Decrypted Message: " + decryptedMessage);

  
    }

    // Method to save the key to a KeyStore
    private static void saveKeyToKeyStore(SecretKey secretKey) throws Exception {
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

    // Method to retrieve the key from the KeyStore
    private static SecretKey getKeyFromKeyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        try (FileInputStream keyStoreInputStream = new FileInputStream(KEYSTORE_FILE)) {
            keyStore.load(keyStoreInputStream, KEYSTORE_PASSWORD.toCharArray());
        }

        // Retrieve the secret key from the KeyStore
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(KEYSTORE_PASSWORD.toCharArray());
        KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry(SECRET_KEY_ALIAS, protectionParam);
        return secretKeyEntry.getSecretKey();
    }

    // Method to encrypt a message using AES
    private static String encrypt(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt a message using AES
    private static String decrypt(String encryptedMessage, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes, "UTF-8");
    }
}