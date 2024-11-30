package ir.freeland.reflection.validation;
import java.lang.reflect.Constructor;

import ir.freeland.reflection.validation.validator.Validator;

public class ReflectionValidationExample {
    public static void main(String[] args) throws Exception {
        // Create a Product instance
        Product product = new Product("Laptop", "JAPAN", "Electronics");

        // Array of validator class names
        String[] validatorClassNames = {
            "ir.freeland.reflection.validation.validator.ProductNameValidator",
            "ir.freeland.reflection.validation.validator.ProductMadeInValidator",
            "ir.freeland.reflection.validation.validator.ProductCategoryValidator"
            };
        
        // Validate the Product using reflection
        validateProduct(product , validatorClassNames);
        
        //THERE IS NO COMPLIE TIME VALIDATION, Change class names
    }

    private static  boolean validateProduct(Product product, String[] validatorClassNames) throws Exception {
    	boolean isValidproduct = true;
        // Loop through the validator class names
        for (int i = 0; i < validatorClassNames.length; i++) {
            // Load the validator class dynamically
            Class<?> validatorClass = Class.forName(validatorClassNames[i]);
            Constructor<?> constructor = validatorClass.getConstructor(Product.class);
            Validator validator = (Validator) constructor.newInstance(product);
            System.out.println(validatorClass.getSimpleName() + " is valid: " + validator.validate());
            isValidproduct = isValidproduct && validator.validate();
        }
        return isValidproduct;

    }
}