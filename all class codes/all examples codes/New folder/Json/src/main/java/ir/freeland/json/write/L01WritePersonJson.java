package ir.freeland.json.write;

import com.fasterxml.jackson.databind.ObjectMapper;

import ir.freeland.json.model.Person;

import java.io.File;
import java.util.Arrays;

public class L01WritePersonJson {
	public static void main(String[] args)
			throws Exception {
		// Create a Person object
        Person person = new Person();
        person.setId(1);
        person.setName("John Doe");
        person.setAge(30);
        person.setHobbies(Arrays.asList("Reading", "Traveling", "Swimming"));

        System.out.println("Person object: " + person);

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("generated-person.json"), person);
        System.out.println("Person object has been saved to person.json");
 
	}
}