package day3.problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	
	
	
	public static String readfile(String filename) throws FileUtilsException {
		String content="";
	try (BufferedReader reader =new BufferedReader(new FileReader(filename));) {
		String line;
		while ((line= reader.readLine())!=null) {
			content+=line;
			
			
		}
	} catch (IOException e) {
		throw new FileUtilsException("problem in reading file");
	}
	return content;
		
	}
	
	public static void writefile(String data, String filename) throws FileUtilsException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write(data);
		} catch (IOException e) {
			throw new FileUtilsException("problem in writing file");
		}
	
		
		
	}
	

}
