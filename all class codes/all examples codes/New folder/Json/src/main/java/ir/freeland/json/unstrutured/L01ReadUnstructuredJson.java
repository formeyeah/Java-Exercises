package ir.freeland.json.unstrutured;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

//Transform structure is highly dynamic, and does not map nicely to Java classes
public class L01ReadUnstructuredJson {
    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();        
        JsonNode rootNode = objectMapper.readTree( new File("data-unstruced.json") );
        // Extract required fields
        String fullName = rootNode.path("user").path("name").asText();
        String email = rootNode.path("user").path("contact").path("email").asText();
        String transactionId = rootNode.path("transaction").path("id").asText();
        
        System.out.printf("fullName: %s%n and email: %s%n, transactionId: %s%n",
        					fullName, email , transactionId);
                
    }
}