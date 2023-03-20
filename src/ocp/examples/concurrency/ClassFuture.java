package ocp.examples.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClassFuture {

	public static void main(String[] args) {
		SquareCalculator squareCalculator = new SquareCalculator();

		Future<Integer> future1 = squareCalculator.calculate(10);
		Future<Integer> future2 = squareCalculator.calculate(100);
		try {
			while (!(future1.isDone() && future2.isDone())) {
				System.out.println(
						String.format(
								"future1 is %s and future2 is %s", 
								future1.isDone() ? "done" : "not done", 
										future2.isDone() ? "done" : "not done"
								)
						);
				Thread.sleep(300);
			}

			Integer result1;
			result1 = future1.get();
			Integer result2 = future2.get();
			System.out.println(result1 + " and " + result2);
			squareCalculator.shutdown();

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class SquareCalculator {    
	private ExecutorService executor = Executors. newFixedThreadPool(2);

	public Future<Integer> calculate(Integer input) {        
		return executor.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});
	}

	public void shutdown() {
		executor.shutdown();
	}
}