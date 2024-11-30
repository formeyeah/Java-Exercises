package ir.freeland.collection.vs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> arrayList = new ArrayList<>();
        // Create a LinkedList
        List<String> linkedList = new LinkedList<>();

        // Adding elements to ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        
        // Adding elements to LinkedList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        // Inserting elements at a specific position
        arrayList.add(1, "Mango"); // Inserts "Mango" at index 1
        linkedList.add(1, "Mango"); // Inserts "Mango" at index 1

        // Accessing elements
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        // Removing elements
        arrayList.remove("Banana"); // Removes "Banana"
        linkedList.remove("Banana"); // Removes "Banana"

        // Displaying the lists after removal
        System.out.println("ArrayList after removal: " + arrayList);
        System.out.println("LinkedList after removal: " + linkedList);

        // Performance comparison (timing)
        long startTime, endTime;

        // Performance test for ArrayList
        //Adding an element at the beginning requires shifting all other elements, 
        //which can be slow (O(n) time complexity).
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, "Test"); // Adding at the beginning
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList add at beginning time: " + (endTime - startTime) + " ns");

        // Performance test for LinkedList
        //Adding an element at the beginning is faster because it involves updating pointers, making it O(1).
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, "Test"); // Adding at the beginning
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList add at beginning time: " + (endTime - startTime) + " ns");
        
        //See: https://www.geeksforgeeks.org/arraylist-vs-linkedlist-java/
    }
}