package ocp.examples.concurrency;

public class Concurrency extends Thread {
	public static int amount = 0;

	public static void main(String[] args) {
		Concurrency thread = new Concurrency();
		// IN CASE OF INTERFACE RUNNABLE
		// Concurrency obj = new Concurrency();
		// Thread thread = new Thread(obj);
		thread.start();
		// Wait for the thread to finish
		while(thread.isAlive()) {
			System.out.println("Waiting...");
		}
		// Update amount and print its value
		System.out.println("Main: " + amount);
		amount++;
		System.out.println("Main: " + amount);
	}
	public void run() {
		amount++;
	}
}