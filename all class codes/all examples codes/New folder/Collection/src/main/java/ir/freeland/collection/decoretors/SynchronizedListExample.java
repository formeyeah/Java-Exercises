package ir.freeland.collection.decoretors;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SynchronizedListExample {
    public static void main(String[] args) {
        // Create a modifiable list
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("Apple");
        modifiableList.add("Banana");
        modifiableList.add("Cherry");

        // Create a synchronized list
        List<String> synchronizedList = Collections.synchronizedList(modifiableList);

        // Adding elements to the synchronized list
        synchronizedList.add("Date");
        synchronizedList.add("Elderberry");

        // Accessing elements in a synchronized manner
        synchronized (synchronizedList) {
            for (String fruit : synchronizedList) {
                System.out.println(fruit);
            }
        }

        // Removing an element from the synchronized list
        synchronizedList.remove("Banana");

        // Displaying the updated synchronized list
        synchronized (synchronizedList) {
            System.out.println("After removal: " + synchronizedList);
        }
    }
}