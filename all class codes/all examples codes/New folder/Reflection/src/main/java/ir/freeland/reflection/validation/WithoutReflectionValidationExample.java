package ir.freeland.reflection.validation;
import ir.freeland.reflection.validation.validator.ProductCategoryValidator;
import ir.freeland.reflection.validation.validator.ProductMadeInValidator;
import ir.freeland.reflection.validation.validator.ProductNameValidator;

public class WithoutReflectionValidationExample {
    public static void main(String[] args) throws Exception {
        
        Product product = new Product("Laptop", "JAPAN", "Electronics");
        //Should create validators, it is hard to change validator RULES       		
        ProductNameValidator productNameValidator = new ProductNameValidator( product );
        ProductMadeInValidator productMadeInValidator = new ProductMadeInValidator( product);
        ProductCategoryValidator productCategoryValidator = new ProductCategoryValidator( product );
        
        boolean isValidProduct = productNameValidator.validate() 
        					&& productMadeInValidator.validate()
        					&&productCategoryValidator.validate();
        
        System.out.println("Product is valid : " + isValidProduct);
        
     }
}