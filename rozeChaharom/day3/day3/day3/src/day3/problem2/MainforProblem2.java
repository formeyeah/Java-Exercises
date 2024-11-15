package day3.problem2;

import java.util.ArrayList;
import java.util.List;

public class MainforProblem2 {

	public static void main(String[] args) {
		//list e aval
		List<String> accounts1=new ArrayList<>();
		//list e dovom
		List<String> accounts2=new ArrayList<>();
		
		//user ha -> list e account, username, password, cardNumber
		//user haye accounts1 
		User user1=new User(accounts1,"rojina", "123456", "6162");
		User user2=new User(accounts1, "ramina", "123456", "6163");
		
		
		//user haye accounts2 
		User user3=new User(accounts2, "rojina", "123456", "6164");
		User user4=new User(accounts2, "ramina", "123456", "6165");
		
		
		Serialize.serializeUser(user1, "//path/to/file/to/write/there");
		User deserializeduser=deserialize.deserializeUser("user1.ser");
		System.out.println("deserialized: "+ deserializeduser);
		
		

	}

}
