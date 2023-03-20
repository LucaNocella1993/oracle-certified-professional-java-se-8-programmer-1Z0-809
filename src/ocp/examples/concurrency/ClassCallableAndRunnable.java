package ocp.examples.concurrency;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClassCallableAndRunnable { 
	public static void main(String[] args) {   
		Runnable r = ()-> System.out.println("In Runnable");
		Callable<Integer> c = ()-> { System.out.println("In Callable"); return 0; };  
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(r);
		es.submit(r);
		Future<Integer> future = es.submit(c);
		es.shutdown();  
	}
}