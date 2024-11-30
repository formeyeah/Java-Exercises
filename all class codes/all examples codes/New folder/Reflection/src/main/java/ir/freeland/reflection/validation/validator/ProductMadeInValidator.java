package ir.freeland.reflection.validation.validator;

import ir.freeland.reflection.validation.Product;

//Validation for product price
public class ProductMadeInValidator implements Validator {
	private Product product;

	public ProductMadeInValidator(Product product) {
		this.product = product;
	}

	@Override
	public boolean validate() {
		 return product != null && !product.getMadeIn().contains("JAPAN");
	}
}