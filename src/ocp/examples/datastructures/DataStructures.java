package ocp.examples.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class DataStructures {

	/*Use: 
	 * Array for storing a list of static objects; 
	ArrayList for storing and accessing data of a list of objects;
	Vector as ArrayList, but using the concurrency;
	LinkedList to manipulate data of a list of objects;
	HashSet is a collection of items where every item is unique and the elements are sorted by alphabetical order;
	HashMap is a collection of items stored in "key/value" pairs;
	Hashtable as HashMap but using the concurrency; 
	TreeMap and TreeSet use compareTo() or compare() method to compare object;
	Stack follows the LIFO principle i.e. Last In First Out;
	Queue follows the FIFO principle i.e. First In First Out.
	 */

	public static void main(String[] args) {
		System.out.println("ARRAYLIST");
		String[] strings = {"a", "b", "c"};
		System.out.println(strings.length);
		for (String string : strings) {
			System.out.print(string + " ");
		}
		System.out.print("\n\n");

		System.out.println("ARRAYLIST");
		List<String> arrayList = new ArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add(2, "c");
		System.out.println(arrayList.get(2));
		arrayList.remove(2);
		Collections.sort(arrayList, (a,b) -> b.compareTo(a));
		//Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
		//Collections.sort(arrayList, comparator);
		for (String string : arrayList) {
			System.out.print(string);
		}
		System.out.print("\n\n");


		System.out.println("LINKEDLIST");
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("a"); linkedList.add("b"); 
		linkedList.add(2, "c");
		linkedList.addFirst("1");
		System.out.println(linkedList.getFirst());
		linkedList.removeLast();
		for (String string : arrayList) {
			System.out.print(string);
		}
		System.out.print("\n\n");


		System.out.println("VECTOR");
		List<String> vector = new Vector<>();
		vector.add("a");
		vector.add("b");
		vector.add(2, "c");
		System.out.println(vector.get(2));
		vector.remove(2);
		Collections.sort(vector, (a,b) -> b.compareTo(a));
		for (String string : vector) {
			System.out.print(string);
		}
		System.out.print("\n\n");


		System.out.println("HASHMAP");
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "a"); map.put(3, "c"); map.put(2, "b");
		System.out.println(map);
		System.out.println(map.get(1));
		map.remove(1);
		System.out.println(map.size());
		for (Integer i : map.keySet()) {
			System.out.println("key: " + i + " value: " + map.get(i));
		}
		System.out.print("\n");


		System.out.println("HASHTABLE");
		Map<Integer,String> table = new Hashtable<>();
		table.put(1, "a"); table.put(3, "c"); table.put(2, "b");
		System.out.println(table);
		System.out.println(table.get(1));
		table.remove(1);
		System.out.println(table.size());
		for (Integer i : table.keySet()) {
			System.out.println("key: " + i + " value: " + table.get(i));
		}
		System.out.print("\n");


		System.out.println("HASHSET");
		HashSet<String> set = new HashSet<>();
		set.add("b"); set.add("c"); set.add("d"); set.add("a"); set.add("a"); set.add("1"); set.add("0");
		for (String string : set) {
			System.out.print(string + " ");
		}
		System.out.print("\n\n");


		System.out.println("TREEMAP");
		TreeMap<Integer,String> treeMap = new TreeMap<>();
		treeMap.put(2, "b"); treeMap.put(3, "c"); treeMap.put(1, "a");
		System.out.println(treeMap);
		System.out.println(treeMap.get(1));
		treeMap.remove(1);
		System.out.println(treeMap.size());
		for (Integer i : treeMap.keySet()) {
			System.out.println("key: " + i + " value: " + treeMap.get(i));
		}
		System.out.print("\n");


		System.out.println("TREESET");
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("b"); treeSet.add("c"); treeSet.add("d"); treeSet.add("a"); treeSet.add("a"); treeSet.add("1"); treeSet.add("0");
		for (String string : treeSet) {
			System.out.print(string + " ");
		}
		System.out.print("\n\n");


		System.out.println("STACK");
		Stack<String> stack = new Stack<>();
		stack.push("a"); stack.push("b"); stack.push("c");
		System.out.println(stack.peek());
		while (!stack.isEmpty())
		{
			System.out.print(stack.pop());
		}
		System.out.print("\n" + stack);
		System.out.print("\n\n");


		System.out.println("QUEUE");
		ArrayDeque<String> queue = new ArrayDeque<>();
		queue.offer("a"); queue.offer("b"); queue.offer("c");
		System.out.println(queue.peek());
		while (!queue.isEmpty())
		{
			System.out.print(queue.poll());
		}
		System.out.print("\n" + queue);

	}
}
