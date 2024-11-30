package ir.freeland.reflection.whatisit;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Get the Class object associated with the Person class
            Class<?> personClass = Class.forName("Person");

            // Print class name
            System.out.println("Class Name: " + personClass.getName());

            // Get and print constructors
            Constructor<?>[] constructors = personClass.getConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(" - " + constructor);
            }

            // Get and print fields
            Field[] fields = personClass.getDeclaredFields();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println(" - " + field.getName() + " of type " + field.getType().getName());
            }

            // Get and print methods
            Method[] methods = personClass.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println(" - " + method.getName());
            }

            // Create an instance of Person using reflection
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object personInstance = constructor.newInstance("Alice", 30);

            // Access and modify fields using reflection
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); // Bypass private access
            System.out.println("Original Name: " + nameField.get(personInstance));

            // Change the name
            nameField.set(personInstance, "Bob");
            System.out.println("Updated Name: " + nameField.get(personInstance));

            // Invoke methods using reflection
            Method getNameMethod = personClass.getMethod("getName");
            System.out.println("Name via method: " + getNameMethod.invoke(personInstance));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}