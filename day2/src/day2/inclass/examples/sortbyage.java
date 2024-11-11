package day2.inclass.examples;

public class sortbyage implements Comparable<Person>{

	@Override
	public int compareTo(Person o) {
		return o.getAge();
	}

}
