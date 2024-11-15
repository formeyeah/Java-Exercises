package day3.problem3.Service;

import java.util.List;
import java.util.stream.Collectors;

import day3.problem3.Service.Exception.ProductNotFound;
import day3.problem3.model.Product;
import day3.problem3.model.ProductType;

public class ServiceManager {

	private static List<Product> products;
		//if user searched only the name of a product should return everything containingn that name,  
		//but if user did use filtering - > multiple scenarios 
	static {
		Product product1=new Product("laptop", ProductType.DIGITAL, 100, false);
		Product product2=new Product("TV", ProductType.DIGITAL, 1000, true);
		
		Product product3=new Product("shirt", ProductType.CLOTHING, 10, true);
		Product product4=new Product("hat", ProductType.CLOTHING, 100, false);
		
		Product product5=new Product("chair", ProductType.DOMESTIC, 100, false);
		Product product6=new Product("pillow", ProductType.DOMESTIC, 10, true);
		
		products=List.of(product1,product2,product3,product4,product5,product6);
		
	}
	public static List<Product> findProducts(String productName) throws ProductNotFound{
		
		List<Product> foundProducts=products.stream()
				.filter(t -> t.name().equals(productName)).collect(Collectors.toList());
		
		if (foundProducts.isEmpty()==true) {
			throw new ProductNotFound("product not found");
			
		}
		return foundProducts;
		
	}
	
	public static List<Product> findProductsFiltered(String productName, ProductType productType) throws ProductNotFound	{
		//if user chose digital 
		if (productType==ProductType.DIGITAL) {
			List<Product> DigitalProducts=products.stream()
					.filter(t -> t.name().equals(productName) && t.productType().equals(productType.DIGITAL))
					.collect(Collectors.toList());
			
			if (DigitalProducts.isEmpty()==true) {
				throw new ProductNotFound("product not found");
				
			}

			return DigitalProducts;
		}
		
		
		//if user chose clothing 
		else if (productType==productType.CLOTHING) {
			List<Product> ClothingProducts=products.stream()
					.filter(t -> t.name().equals(productName) && t.productType().equals(productType.CLOTHING))
					.collect(Collectors.toList());
			
			if (ClothingProducts.isEmpty()==true) {
				throw new ProductNotFound("product not found");
				
			}
			return ClothingProducts;
			
		}
		//if user chose domestic 
		else if (productType==ProductType.DOMESTIC) {
			List<Product> DomesticProducts=products.stream()
					.filter(t -> t.name().equals(productName) && t.productType().equals(productType.DOMESTIC))
					.collect(Collectors.toList());
			
			if (DomesticProducts.isEmpty()==true) {
				throw new ProductNotFound("product not found");
			}
			return DomesticProducts;
		}
		//if user did not chose anything -> return all 
		else {
			List<Product> foundProducts=products.stream()
					.filter(t -> t.name().equals(productName)).collect(Collectors.toList());
			
			if (foundProducts.isEmpty()==true) {
				throw new ProductNotFound("product not found");
				
			}
			return foundProducts;
			
		}
		

		
		
	/*
	 chatgpt solution
	 public static List<Product> findProductsFiltered(String productName, ProductType productType) {
    return products.stream()
            .filter(product -> (productName == null || product.name().equals(productName)) &&
                               (productType == null || product.productType().equals(productType)))
            .collect(Collectors.toList());
}

	 */
		
		
		
		
		
	}
	

}
