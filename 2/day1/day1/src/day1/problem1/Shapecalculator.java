package day1.problem1;

public class Shapecalculator {
	//hatman bayad static tarif koni chun ke in class objective kar nmikkone
	//goftim vaqti operation bekhym anjam bedim va nkhym new konim az static estfde miknim
	
	public static <T extends Shape> double  CalculateArea(T[] shapes) {
		double total=0;
		int counter=0;
		for (T t : shapes) {
			total=total+t.area();
			counter++;
			System.out.println("chantaro daram total migirm: " + counter);
		}
		return total;
		
	}

}
