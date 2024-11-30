package ir.freeland.collection.decoretors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Unmodifiable {
	public static void main(String[] args) {
		// Create a modifiable list
		List<String> modifiableList = new ArrayList<>();
		modifiableList.add("Apple");
		modifiableList.add("Banana");
		modifiableList.add("Cherry");

		// Create an unmodifiable list 
		//This is unmodifiableXXX ( unmodifiableSet, unmodifiableMap
		List<String> unmodifiableList = Collections
				.unmodifiableList(modifiableList);

		// Display the unmodifiable list
		System.out.println("Unmodifiable List: " + unmodifiableList);

		// Attempting to modify the unmodifiable list will throw an exception
		unmodifiableList.add("Date"); // This will throw

	}

}
