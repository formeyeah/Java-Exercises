package ir.freeland.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapCreate {

	    public static void main(String[] args) {
	        // Step 2: Create a HashMap to store Product objects
	        Map<String, Product> productMap = new HashMap<>();

	        // Step 3: Adding products to the Map
	        productMap.put("P001", new Product("Laptop", 1200));
	        productMap.put("P002", new Product("Smartphone", 800));
	        productMap.put("P003", new Product("Tablet", 600));
	        productMap.put("P004", new Product("Smartwatch", 250));

	        // Step 4: Displaying all products in the Map
	        System.out.println("Products in the Map:");
	        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	        }

	        // Step 5: Retrieving a specific product
	        String productId = "P002";
	        Product product = productMap.get(productId);
	        if (product != null) {
	            System.out.println("\nRetrieved Product: " + product);
	        } else {
	            System.out.println("\nProduct with ID " + productId + " not found.");
	        }

	        // Step 6: Removing a product
	        productMap.remove("P003");
	        System.out.println("\nProducts after removing P003:");
	        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	        }

	        // Step 7: Checking if a key exists
	        String checkId = "P001";
	        if (productMap.containsKey(checkId)) {
	            System.out.println("\nProduct with ID " + checkId + " exists in the map.");
	        } else {
	            System.out.println("\nProduct with ID " + checkId + " does not exist in the map.");
	        }
 }

}