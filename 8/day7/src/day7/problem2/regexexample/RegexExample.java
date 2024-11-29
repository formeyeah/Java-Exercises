package day7.problem2.regexexample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
	String text="console.write(hello,world)";
	String textForloop="hello my name is hello and I want to hello ";
	String regex="hello\\,";
	String regexForloop="hello";
	Pattern pattern=Pattern.compile(regex);
	Matcher matcher=pattern.matcher(text);
	
	
	Pattern pattern2=Pattern.compile(regexForloop);
	Matcher matcher2=pattern2.matcher(textForloop);
	
	
	String textreplaced=text.replaceAll(regex, "hi ");
	System.err.println(textreplaced);
	
	if (matcher.find()) {
		System.out.println("found match: "+ matcher.group()+"\n"+ "with this pattern: "+ matcher.pattern());
	}
	while (matcher2.find()) {
		System.out.println("Found: "+ matcher2.group());
		
	}
	}

}
