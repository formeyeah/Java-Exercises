package ir.freeland.reflection.validation.validator;

import ir.freeland.reflection.validation.Product;

//Validation for product name
public class ProductNameValidator implements Validator {
 private Product product;

 public ProductNameValidator(Product product) {
     this.product = product;
 }

 @Override
 public boolean validate() {
     return product != null && !product.getName().trim().isEmpty();
 }
}