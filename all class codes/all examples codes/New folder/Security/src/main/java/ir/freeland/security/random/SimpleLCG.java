package ir.freeland.security.random;

import java.util.Scanner;

/**
 * Simple Java Program Using Numbers Linear Congruential Generator (LCG)
 * to generate LCG "Pseudorandom"  which is easy to implement and understand.
 * 
 * Xn+1 = (a×Xn+c) mod m
 * 
 * Example: 
 * X0=7 a=5 c=1 m=16
 *   
 * X1 = (5×7+1) mod 16  = (35+1) mod 16 = 36 mod 16 = 4 
 * X2 = (5×4+1) mod 16  = (20+1) mod 16 = 21 mod 16 = 5 
 * X3 = (5×5+1) mod 16  = (25+1) mod 16 = 26 mod 16 = 10 
 * X4 = (5×10+1)mod 16  = (50+1) mod 16 = 51 mod 16 = 3
 * X5 = (5*3+1) mod 16  = (15+1) mod 16 = 16 mod 16 = 0
 * X6 = (5×0+1) mod 16  = (0+1)  mod 1  6= 1 mod 16 = 1
 * 
 */
public class SimpleLCG {
	// Constants for the LCG
	private static final long a = 1664525; // Multiplier
	private static final long c = 1013904223; // Increment
	private static final long m = (1L << 32); // Modulus (2^32)

	private long seed; // Current seed

	// Constructor to initialize the seed
	public SimpleLCG(long seed) {
		this.seed = seed;
	}

	// Method to generate the next pseudorandom number
	public long next() {
		seed = (a * seed + c) % m; // Update seed
		return seed; // Return the new pseudorandom number
	}

	public static void main(String[] args) {
		// Create a Scanner object for user input
		Scanner scanner = new Scanner(System.in);

		// Prompt the user for the number of random integers to generate
		System.out.print("Enter the number of random integers to generate: ");
		int count = scanner.nextInt();

		// Prompt the user for the initial seed value
		System.out.print("Enter the seed value: ");
		long seed = scanner.nextLong();

		// Create an instance of the SimpleLCG
		SimpleLCG lcg = new SimpleLCG(seed);

		// Generate and print the random integers
		System.out.println("Generated Pseudorandom Integers:");
		for (int i = 0; i < count; i++) {
			long randomInt = lcg.next(); // Generate next random number
			System.out.println(randomInt);
		}

		// Close the scanner
		scanner.close();
	}
}