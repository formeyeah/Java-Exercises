package ir.freeland.security.random;

import java.util.Random;

public class RandomMain {
	public static void main(String[] args) {
		Random random = new Random();

		// Generate random integers
		int randomInt = random.nextInt(); // Any integer
		int randomIntBounded = random.nextInt(100); // Integer between 0 and 99

		// Generate random doubles
		double randomDouble = random.nextDouble(); // Between 0.0 and 1.0

		// Print the generated random numbers
		System.out.println("Random Integer: " + randomInt);
		System.out.println("Random Integer (0-99): " + randomIntBounded);
		System.out.println("Random Double: " + randomDouble);
	}
}
/**
 * 
 * This is Pseudorandom Number Generators (PRNGs) : 
 * 1. Deterministic Nature of Computers 
 * 2. Finite State Space ( will reproduce numbers after a while) 
 * 3. Seed Quality 
 * 4. Entropy Sources:True randomness is often derived from unpredictable physical processes 
 * (like thermal noise, radioactive decay, or atmospheric noise).
 * 
 */