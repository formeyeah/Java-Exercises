package ir.freeland.security;

import java.util.Base64;

/**
 * Base64 is an encoding scheme that was invented to facilitate the transmission
 * of binary data over channels that only support text.
 * 
 * Many communication protocols and data formats, especially those that were
 * developed in the early days of computing (such as email and HTTP), were
 * designed to handle text data.
 * 
 */
public class Base64ByteArrayMain {
	public static void main(String[] args) {
		//Note: Max byte is 256 but it is signed max will be 127
		
		// Create a byte array (for example, some arbitrary binary data)
		byte[] originalByteArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

		// Print the original byte array
		System.out.println("Original Byte Array: ");
		for (byte b : originalByteArray) {
			System.out.print(b + " ");
		}

		System.out.println("\nOriginal Byte Array (Bit by Bit): ");
		for (byte b : originalByteArray) {
			for (int i = 7; i >= 0; i--) { // Iterate from 7 to 0 to get bits
											// from most significant to least
											// significant
				// Use bitwise AND and right shift to extract each bit
				System.out.print(((b >> i) & 1));
			}
			System.out.print(" ");
		}
		System.out.println();

		// Encoding the byte array to Base64
		String encodedString = Base64.getEncoder().encodeToString(originalByteArray);
		System.out.println("Encoded Byte Array (Base64): " + encodedString);

		// Decoding the Base64 string back to the original byte array
		byte[] decodedByteArray = Base64.getDecoder().decode(encodedString);

		// Print the decoded byte array
		System.out.print("Decoded Byte Array: ");
		for (byte b : decodedByteArray) {
			System.out.print(b + " ");
		}
	}
}