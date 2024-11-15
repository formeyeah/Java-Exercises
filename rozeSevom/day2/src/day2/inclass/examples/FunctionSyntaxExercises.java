package day2.inclass.examples;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//import javax.swing.text.StyledEditorKit.BoldAction;

public class FunctionSyntaxExercises {
	public static void main(String[] args) {
		Function<String, String> UppercaseFunction=new Function<String, String>() {
			
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
			
		};
		
		String upper1=UppercaseFunction.apply("hello world!");
		System.out.print(upper1);
		
		
		Function<String, String> upper2Function=t -> {return t.toUpperCase();};
		Function<String, String> upper3Function=t ->t.toLowerCase();
		Function<String, String> upper4Function= String::toUpperCase; //-> be in migan method reference 
		
		
		Consumer<String> print= s-> System.out.println(s);
		//how to call consumer functions: 
		print.accept("Hiiii");
		
		
		//bi function 
		BiFunction<String, String, String> addBiFunction=(t, u) -> t+u;
		String help=addBiFunction.apply("hello", "world");
		System.out.println(help);
		
		
		//predicate function
		Predicate<String> ishasan=t -> t.contains("hasan");
		System.out.print(ishasan.test("helpme hasan"));
		

		
		
		
		
		 
	}

}
