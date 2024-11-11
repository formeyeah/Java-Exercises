package day2.inclass.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MainforPerson {

	public static void main(String[] args) {
		Person person1 = new Person("Rojina", "email1@gmail.com", 20);
		Person person2 = new Person("ramina", "email2@gmail.com", 27);
		Person person3 = new Person("someone", "email3@gmail.com", 10);
		
		
		//sade tarin ravesh baraye por kardan yek List 
		//solution 1
		List<Person> persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		//ya mitonim object haro berizim to ye array va array ei az object haro bahash kar konim 
		//miaym array ei az object haro midim be list ta list kone
		//solution 2 
		Person [] personsArray= {person1, person2, person3};
		//aslist array ro be list tabdil mikone
		List<Person> persons1 =Arrays.asList(personsArray);
		
		persons.add(0, person3);
		System.out.println("added someone to 0 :"+ persons);
		
		List childs=persons.subList(0, 3);
		System.out.println("child of persons: "+ childs);
		
		persons.remove(0);
		System.out.println("removed someone from 0: " +persons);
		
		persons.contains(person1);
		System.out.println(persons.indexOf(person1));
		
		//hala mikhym ye chizi ro to in list person peyda konim 
		
		
		
		//iterator 
		for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
			Person person= (Person) iterator.next();
			
			//person.setName(person.getName().toUpperCase());
			
			if (person.getAge()>10) {
				iterator.remove();
				
			}
			System.out.println(persons);
	
		}
		
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		
		//Collections.sort(persons, new sortbyage());
		

	}

}
