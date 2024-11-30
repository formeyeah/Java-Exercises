package ir.freeland.json.unstrutured;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.freeland.json.model.Cinema;
import ir.freeland.json.model.CinemaType;

import java.io.File;
import java.util.List;

//Transform structure is highly dynamic, and does not map nicely to Java classes
public class L02WriteUnstructuredJson {
    public static void main(String[] args) throws Exception{
    	File file = new File("generated-unstructured.json");
    	
    	ObjectMapper objectMapper =  JsonMapper.builder()
    			.enable( SerializationFeature.INDENT_OUTPUT ) //enable pretty-printing"
    			.enable( SerializationFeature.FAIL_ON_EMPTY_BEANS ) //prevent exception when encountering unknown property
    			.build();              
        
        ObjectNode root = objectMapper.createObjectNode();
        root.put("fullName", "Alireza Fattahi");
        root.put("email", "afattahi54@gmail.com");
        root.put("age", 48);
        root.putPOJO("kids", List.of("Arefeh","Roham"));
        root.putPOJO("Like Cinema", new Cinema("Paradise", "Tehran" , 10, CinemaType.DRIVE_IN));
       
        // write root too file
        objectMapper.writeValue(file, root );
        
        System.out.println( "Saved Root: " + root );

    }
}