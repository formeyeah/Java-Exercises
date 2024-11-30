package ir.freeland.annotation.define;

public class AnnotationExample {

    public static void main(String[] args) {
        // Get the class object of MyAnnotatedClass
        Class<MyAnnotatedClass> obj = MyAnnotatedClass.class;

        // Check if the annotation is present
        if (obj.isAnnotationPresent(Info.class)) {
            // Retrieve the annotation
            Info info = obj.getAnnotation(Info.class);

            // Display the annotation values
            System.out.println("Author: " + info.author());
            System.out.println("Date: " + info.date());
            System.out.println("Version: " + info.version());
        }
    }
}