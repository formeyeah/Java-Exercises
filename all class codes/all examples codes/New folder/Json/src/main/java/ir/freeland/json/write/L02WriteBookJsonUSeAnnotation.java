package ir.freeland.json.write;

import com.fasterxml.jackson.databind.ObjectMapper;

import ir.freeland.json.model.Book;
import ir.freeland.json.model.BookFormat;
import java.io.File;
import java.util.Arrays;

public class L02WriteBookJsonUSeAnnotation {
	public static void main(String[] args)
			throws Exception {
		// Create a Book object
		Book book = new Book();
		book.setTitle("The Hobbit");
		book.setAuthor("J.R.R. Tolkien");
		book.setPublishedYear(1937);
		book.setGenres(Arrays.asList("Fantasy", "Adventure"));
		book.setBookFormat(BookFormat.PAPERBACK);
		book.setInternalNote("A classic fantasy novel."); // This will be ignored during serialization


        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("generated-book.json"), book);
        System.out.println("Book object has been saved to generated-book.json");
 
	}
	
}