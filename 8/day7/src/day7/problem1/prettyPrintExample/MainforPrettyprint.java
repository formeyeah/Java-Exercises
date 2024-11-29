package day7.problem1.prettyPrintExample;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MainforPrettyprint {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Account account=new Account("102");
		Person person=new Person("rojina", "b",account);
		ObjectMapper objecmapper=new ObjectMapper();
		  objecmapper.enable(SerializationFeature.INDENT_OUTPUT);
		  File file=new File("person-pretty.json");
		
		objecmapper.writeValue(file, person);
		
		System.out.println("wrote to person-pretty.json"+ file.getAbsolutePath());
		
		//the other method to do this: 
		
		Account account2=new Account("103");
		Person person2=new Person("ramina","b",account2);
		objecmapper.writerWithDefaultPrettyPrinter().writeValue(new File("prettyPrint2.json"), person2);
		System.out.println("wrote to prettyuPrint2.json");

	}

}
