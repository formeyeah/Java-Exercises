package day2.inclass.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainforProduct {

	public static void main(String[] args) {
		Product product1= new Product("laptop", 1000);
		Map<String, Product> productMap=new HashMap<>();
		productMap.put("p01", product1);
		productMap.put("p02", new Product("mobile", 10));
		productMap.put("p03", new Product("TV", 1000));

		
		
		for (Map.Entry<String, Product> entry : productMap.entrySet()) {
			String key = entry.getKey();
			Product val = entry.getValue();
			System.out.println("product "+ key+" "+val);
			
		}
		//ye value midim ye object e product barmigrdne
		
		
		productMap.get("p01");
		productMap.remove("p02");
		productMap.containsKey("p01");
		productMap.containsValue(product1);
		
		//ye ravesh dige bara tarif list 
		List<Product> list1= List.of(product1);
		System.out.println(list1);
		

	}

}
