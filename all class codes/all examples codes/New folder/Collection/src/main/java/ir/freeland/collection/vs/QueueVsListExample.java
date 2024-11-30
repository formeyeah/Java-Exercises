package ir.freeland.collection.vs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueVsListExample {
    public static void main(String[] args) {
        // Example using List
        List<String> taskList = new ArrayList<>();
        
        // Adding tasks to the List
        taskList.add("Task 1");
        taskList.add("Task 2");
        taskList.add("Task 3");
        taskList.add("Task 1"); // Duplicate task
        
        // Displaying the tasks in the List
        System.out.println("Tasks in List:");
        for (String task : taskList) {
            System.out.println(task);
        }
        System.out.println("The taskQueue is " + taskList); //The list still has items
        
        // Example using Queue
        Queue<String> taskQueue = new LinkedList<>(); //LinkedList Again!! See java doc: LinkedList is List and Queue  
        
        // Adding tasks to the Queue
        taskQueue.add("Task A");
        taskQueue.add("Task B");
        taskQueue.add("Task C");
        taskQueue.add("Task A"); // Duplicate task
        
        // Displaying the tasks in the Queue
        System.out.println("\nTasks in Queue (FIFO):");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll()); // Process and remove the task from the queue
        }
        System.out.println("The taskQueue is " + taskQueue); //The queue is empty
    }
}
