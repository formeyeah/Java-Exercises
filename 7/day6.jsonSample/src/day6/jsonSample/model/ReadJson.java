package day6.jsonSample.model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file=new File("account.json");
		ObjectMapper objectMapper=new ObjectMapper();
		account account= objectMapper.readValue(file, account.class);
		System.out.println(account);
		
		

	}

}
