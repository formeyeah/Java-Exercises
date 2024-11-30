package ir.freeland.collection.vs;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import ir.freeland.collection.model.Product;

public class SetVsNavigatableSet {
	public static void main(String[] args) {

		Product laptop = new Product(1, "laptop", 10000);
		Product mobile = new Product(2, "mobile", 500);
		Product tablet = new Product(3, "tablet", 100);
		Product flash = new Product(4, "flash", 10);

		NavigableSet<Product> products = new TreeSet<>();
		products.addAll(Set.of(laptop, mobile, tablet, flash));

		// Displaying all products in the NavigableSet
		System.out.println("All Products:");
		for (Product product : products) {
			System.out.println(product);
		}

		// Step 3: Navigating through the NavigableSet
		// Get the lowest priced product
		System.out.println("\nLowest Priced Product: " + products.first());

		// Get the highest priced product
		System.out.println("Highest Priced Product: " + products.last());

		// Get the product just higher than a specific price
		Product higherProduct = products.higher(new Product(5, "Dummy", 200));
		System.out.println("Product just higher than $500: "+ higherProduct);

		// Get the product just lower than a specific price
		Product lowerProduct = products.lower(new Product(6, "Dummy", 100));
		System.out.println("Product just lower than $100 : "+ lowerProduct);

		// Get a view of the products less than a specific price
		System.out.println("\nProducts less than $100:"
				+ products.headSet(new Product(7, "Dummy", 100), false));

		// Get a view of the products greater than or equal to a specific price
		System.out.println("Products greater than or equal to $100"
				 + products.tailSet(new Product(8, "Dummy", 1), true));
	}
}
