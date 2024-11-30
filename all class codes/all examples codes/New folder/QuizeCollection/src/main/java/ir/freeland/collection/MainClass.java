package ir.freeland.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ir.freeland.collection.model.Address;
import ir.freeland.collection.model.House;

public class MainClass {
	public static void main(String[] args) {
		
		Address address1 = new Address("Tehran","vanak"); 
		House house1= new House("BlackHouse",  address1 ,100,4,1000);
		
		Address address2 = new Address("Tehran","tajrish"); 
		House house2= new House("RedHouse",  address2 ,40 , 1 , 800);
		
		Address address3 = new Address("Shirza","abassi"); 
		House house3= new House("GreenHouse",  address3 , 110 , 4 , 1200);

		Address address4 = new Address("Tehran","mirdamad"); 
		House house4= new House("PinkHouse",  address4 , 50 , 2 , 800);
		
		Address address5 = new Address("Tehran","mirdamad"); 
		House house5 = new House("YellowHouse",  address5 , 140 , 4 , 1500);

		Address address6 = new Address("Shirza","gandi"); 
		House house6 = new House("BlueHouse",  address6 , 120 , 3 , 950);

		Address address7 = new Address("Tabriz","salehi"); 
		House house7 = new House("BlueHouse",  address7 , 80 , 2 , 650);

		//Create List of houses
		List<House> houses=List.of(house1, house2,house3, house4, house5, house6,house7); 
		//write a function/predict... : isGoodForElderly ( price < 1000$ and area < 100m2 ) 
		Predicate<House> isGoodForElderly=t -> t.getPrice()<1000 && t.getArea()<100;
		
		//print all houses which are located in Tehran
		houses.stream().filter(t -> t.getAddress().getCity().equals("Tehran"))
		.forEach(t -> System.out.println("houses in tehran is"+t));
		
		//A new list of houses located in Tehran which have 3 rooms
		List<House> specifichouse=houses.stream().filter(t -> t.getAddress().getCity().equals("Tehran"))
				.filter(t -> t.getRoom()==3).collect(Collectors.toList());
		System.out.println("houses in tehran and have 3 room"+specifichouse);
		
		//find the "YellowHouse" in the list and print it
		House 	findYellowhouse=houses.stream().filter(t -> t.getName().equals("YellowHouse"))
			.findFirst().get();
		System.out.println("we have found first YelloHouse"+findYellowhouse);	
		
		//make a new list and remove duplicated houses, the house are duplicate if they have same name
		//*******************************************************************************************
		List<House> specifichouse2 = houses.stream()
		        .collect(Collectors.collectingAndThen(
		                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(House::getName))),
		                ArrayList::new));
		System.out.println("List of houses with unique names: " + specifichouse2);
		
		//Average price of houses with area between 50 to 80 m2 sort by City
		double average=houses.stream().filter(t -> t.getArea()>50).filter(t -> t.getArea()<80 )
			.sorted((o1, o2) -> o1.getAddress().getCity().compareTo(o2.getAddress().getCity()))
			.collect(Collectors.averagingDouble(t->t.getPrice()));
		System.out.println("the average price houses 50<area<80 and sort by city is:"+ average);
				
		//Group house by the number of rooms
		Map<Integer,List<House>> maproom=houses.stream()
				.collect(Collectors.groupingBy(House::getRoom));
		System.err.println("number of rooms"+"\t\t"+"houses");
		maproom.forEach((t, u) -> System.out.println(t+"\t\t"+u));
		//Partition houses which are suitable for elderly
		Map<Boolean,List<House>> suithouse=houses.stream()
				.collect(Collectors.partitioningBy(isGoodForElderly));
		System.err.println("houses are suitable for elderly");
		suithouse.forEach((t, u) -> System.out.println(t +"\t\t"+u));
		//Group house by the number of rooms and sort each group by price
		//**************************************************************************************
		Map<Integer,List<House>> maproom2=houses.stream()
		        .collect(Collectors.groupingBy(
		                House::getRoom, 
		                Collectors.collectingAndThen(
		                        Collectors.toList(),
		                        list -> list.stream()
		                                .sorted(Comparator.comparing(House::getPrice))
		                                .collect(Collectors.toList())
		                )
		        ));
		
		System.err.println("number of room"+"\t\t"+"list of house sorted price");
		maproom2.forEach((t, u) ->System.out.println(t+"\t\t"+u) );
		
	}
}
