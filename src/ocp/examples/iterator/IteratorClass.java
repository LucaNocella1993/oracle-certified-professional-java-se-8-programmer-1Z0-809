package ocp.examples.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorClass {

	public static void main(String[] begin) {
		List<String> list = new ArrayList<>();
		list.add("a"); list.add("b"); list.add("c"); list.add("d");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String element = it.next();
			System.out.println(element);
			if (element.equals("a")) {
				it.remove();
			}
		}

		for (String element : list) {
			System.out.println(element);
		}

	}

}