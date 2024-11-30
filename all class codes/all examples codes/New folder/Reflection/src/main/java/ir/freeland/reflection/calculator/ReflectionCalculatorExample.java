package ir.freeland.reflection.calculator;

import java.lang.reflect.Method;

public class ReflectionCalculatorExample {
    public static void main(String[] args) throws Exception {

            // Load the Calculator class dynamically
            Class<?> calculatorClass = Class.forName("Calculator");

            // Create an instance of Calculator
            Object calculatorInstance = calculatorClass.getDeclaredConstructor().newInstance();

            // Define the method names and parameters
            String[] methodNames = {"add", "subtract", "multiply", "divide"};
            Object[][] methodParams = {
                {5, 3},
                {10, 4},
                {7, 6},
                {20, 4}
            };

            // Loop through the methods and invoke them
            for (int i = 0; i < methodNames.length; i++) {
                // Get the method by name and parameter types
                Method method = calculatorClass.getMethod("add", int.class, int.class);

                // Invoke the method on the calculator instance
                Object result = method.invoke(calculatorInstance, methodParams[i]);

                // Print the result
                System.out.println(methodNames[i] + "( " + methodParams[i][0] + ", " + methodParams[i][1] + " ) = " + result);
            }

    }
}