package ir.freeland.json.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.freeland.json.model.Book;
import java.io.File;

//Use of annotations @JsonProperty @JsonIgnore
public class L02ReadBookJsonUseAnnotations {
	public static void main(String[] args)
			throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		File file = new File("data-book.json");
		Book book = objectMapper.readValue(file, Book.class);
		System.out.println(book);

	}
}