package ocp.examples.concurrency;

import java.util.Arrays;
import java.util.List;

public class ReduceAndCombine {
	public static void main (String... args) {
		List<String> vals = Arrays.asList("a", "b", "c", "d", "e");
		String join = vals.parallelStream() 
				.peek(System.out::println) //this shows how the elements are retrieved from the stream
				.reduce("_",
						(a, b)->{
							System.out.println("reducing "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
							return a.concat(b);},
						(a, b)->{
							System.out.println("combining "+a+" and "+b+" Thread: "+Thread.currentThread().getName()); 
							return a.concat(b); }
						);
		System.out.println(join);
	}
}
