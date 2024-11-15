package day3.problem3;

import day3.problem3.Service.ServiceManager;
import day3.problem3.Service.Exception.ProductNotFound;
import day3.problem3.model.ProductType;

public class DigiKalaSimulationApplication {

	public static void main(String[] args) {
		try {
			var foundProduct=ServiceManager.findProducts("laptop");
			System.out.println("your product: "+ foundProduct);
		} catch (ProductNotFound e) {
		System.err.println("product not found");
		}
		try {
			var foundProduct=ServiceManager.findProducts("mobile");
			System.out.println("your product: "+ foundProduct);
		} catch (ProductNotFound e) {
			System.err.println("product not found");
		}
		try {
			var foundProduct=ServiceManager.findProductsFiltered("shirt", ProductType.CLOTHING);
			System.out.print(foundProduct);
		} catch (ProductNotFound e) {
			System.err.println("product not found");
		}
		try {
			var foundProduct=ServiceManager.findProductsFiltered("laptop", ProductType.CLOTHING);
			System.out.print(foundProduct);
		} catch (ProductNotFound e) {
			System.err.println("product not found");
		}
		

	}

}
