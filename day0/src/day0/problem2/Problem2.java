package day0.problem2;

public class Problem2 {

	public static void main(String[] args) {
		String name="Rojina";
		switch (name) {
		case "Rojina" -> System.out.println(name +" "+ " is a female");
		case "Ali" -> System.out.println(name + " "+"is a male");		
		default ->System.out.println("I don't know " + name);
		}
		
	}

}
