package ir.freeland.json.read;

import com.fasterxml.jackson.databind.ObjectMapper;

import ir.freeland.json.model.Person;

import java.io.File;

public class L01ReadPersonJson {
	public static void main(String[] args)
			throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		File file = new File("person.json");
		Person person = objectMapper.readValue(file, Person.class);
		System.out.println(person);

	}
}