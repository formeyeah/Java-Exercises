package inClassexample.day8;

import java.security.SecureRandom;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		Random random=new Random();
		int Rand=random.nextInt();
		System.out.println(Rand);
		int Rand1=random.nextInt(100);
		System.out.println(Rand1);
		
		double randdouble=random.nextDouble();
		System.out.println(randdouble);
		
		
		
		SecureRandom securerandom=new SecureRandom();
		byte[] randombytes=new byte[1];
		securerandom.nextBytes(randombytes);
		for (byte b : randombytes) {
			System.out.println(b);
		}
	}

}
