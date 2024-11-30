package ir.freeland.collection.vs;

import java.util.PriorityQueue;
import java.util.Comparator;

public class QueueVsPriorityQueue {
    public static void main(String[] args) {
        // Create a PriorityQueue with a custom comparator to prioritize lower values
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));

        // Adding tasks to the PriorityQueue
        taskQueue.add(new Task("Task 1", 3)); // Lower priority
        taskQueue.add(new Task("Task 2", 1)); // Higher priority
        taskQueue.add(new Task("Task 3", 2)); // Medium priority

        // Processing tasks based on priority
        System.out.println("Processing tasks in order of priority:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll(); // Retrieves and removes the task with the highest priority
            System.out.println(task);
        }
    }
}

class Task {
    private String name;
    private int priority; // Lower value means higher priority

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}
