package ir.freeland.json.read;

import com.fasterxml.jackson.databind.ObjectMapper;

import ir.freeland.json.model.Library;

import java.io.File;

//Use of annotations @JsonProperty @JsonIgnore a complete example
public class L03ReadLibraryJsonCompleteObject {
    public static void main(String[] args) throws Exception{
    	File file = new File("data-librarys.json");    	
        ObjectMapper objectMapper = new ObjectMapper();
        
        Library library = objectMapper.readValue(file, Library.class);
                
        library.magazines().forEach(System.out::println);
    }
}