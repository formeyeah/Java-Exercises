package ir.freeland.collection.vs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ir.freeland.collection.model.Customer;

public class ListVsSet {
    public static void main(String[] args) {
   
		Customer alireza = new Customer(1, "Alireza", "afattahi54@gmail.com", 48);
		Customer roham = new Customer(2, "Roham", "afattahi54@gmail.com", 10);
		Customer arefeh = new Customer(3, "Arefeh", "arefeh@gmail.com", 15);
		
		List<Customer> customers = new ArrayList<>();
		customers.add(alireza);
		customers.add(roham);
		customers.add(arefeh);
		System.out.println(customers);
		
		Set<Customer> uniqueCustomers = new HashSet<>();
		uniqueCustomers.add(alireza);
		uniqueCustomers.add(roham);
		uniqueCustomers.add(arefeh);
		
		System.out.println(uniqueCustomers); //see equal
		//The output is not ordered!!
		
    }
}