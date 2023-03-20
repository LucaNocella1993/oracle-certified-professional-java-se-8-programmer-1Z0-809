package ocp.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class TestClass {  

	public static void main(String[] args) throws Exception    {
		List<String> letters = Arrays.asList("j", "a", "v","a");

		UnaryOperator<String> uo = String::toUpperCase;
		letters.replaceAll(uo);
		letters.forEach(System.out::print);
	}
}