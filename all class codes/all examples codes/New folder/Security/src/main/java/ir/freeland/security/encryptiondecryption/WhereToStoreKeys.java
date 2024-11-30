package ir.freeland.security.encryptiondecryption;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


/**
 * 1. Environment Variables Description: 
 * Store the key in environment variables
 * instead of hardcoding it in your application code. This approach keeps
 * sensitive information out of the source code. Implementation: Access the key
 * using System.getenv("YOUR_ENV_VARIABLE_NAME") in your Java application. 
 * 
 * 2.Configuration Files Description: 
 * Use external configuration files (e.g.,
 * .properties, .yaml, or .json files) to store keys. Ensure that these files
 * are not included in version control (e.g., by adding them to .gitignore).
 * Implementation: Use libraries like Apache Commons Configuration or Spring
 * Boot’s configuration management to read keys from configuration files. 
 * 
 * 3. Key Management Services (KMS) Description: Use a dedicated key management
 * service, such as AWS Key Management Service (KMS), Azure Key Vault, or
 * HashiCorp Vault. These services provide secure storage, access control, and
 * auditing capabilities. Implementation: Integrate your application with the
 * KMS API to retrieve the key at runtime. 
 * 
 * 4. Secure Storage Solutions
 * Description: Use secure storage solutions such as HSM (Hardware Security
 * Modules) or TPM (Trusted Platform Module) for storing keys. These are
 * specialized hardware devices designed to manage and protect cryptographic
 * keys. Implementation: Use libraries or APIs provided by the hardware vendors
 * to interact with the secure storage. 
 * 
 * 5. Encryption at Rest Description: 
 * If you must store keys in files or databases, ensure that they are encrypted at
 * rest. Use a separate encryption key to encrypt the symmetric keys.
 * Implementation: Use AES or another encryption algorithm to encrypt the keys
 * before storing them and decrypt them when needed. 
 * 
 * 6. Access Control
 * Description: Limit access to the keys to only those parts of the application
 * that need them. Implement proper access control measures. Implementation: Use
 * role-based access control (RBAC) or similar mechanisms to restrict access.
 */

public class WhereToStoreKeys {
    public static void main(String[] args) throws Exception {
   
            // Step 1: Retrieve the predefined key from an environment variable
            String keyString = System.getenv("AES_SECRET_KEY"); // Assume this is set to 16 bytes
            SecretKeySpec secretKey = new SecretKeySpec(keyString.getBytes("UTF-8"), "AES");

            // Step 2: Encrypt a message using the predefined key
            String originalMessage = "Hello, this is a secret message!";
            String encryptedMessage = encrypt(originalMessage, secretKey);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Step 3: Decrypt the message using the same predefined key
            String decryptedMessage = decrypt(encryptedMessage, secretKey);
            System.out.println("Decrypted Message: " + decryptedMessage);

        
    }

    // Method to encrypt a message using AES
    private static String encrypt(String message, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt a message using AES
    private static String decrypt(String encryptedMessage, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes, "UTF-8");
    }
}
