package ir.freeland.reflection.validation.validator;

import ir.freeland.reflection.validation.Product;

//Validation for product category
public class ProductCategoryValidator implements Validator {
 private Product product;

 public ProductCategoryValidator(Product product) {
     this.product = product;
 }

 @Override
 public boolean validate() {
     return product != null && !product.getCategory().trim().isEmpty();
 }
}