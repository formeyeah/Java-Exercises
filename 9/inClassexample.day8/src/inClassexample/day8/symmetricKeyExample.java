package inClassexample.day8;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class symmetricKeyExample {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		
	SecretKey secretKey=keyGenerator
			.generateKey();
	
	//encrypt 
	Cipher cipher=Cipher.getInstance("AES");
	cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	byte[] encrypted=cipher.doFinal("Hello".getBytes());
	
	Base64.getEncoder().encodeToString(encrypted);
	

	
	   
	
	
	}

}
