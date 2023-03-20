package ocp.examples.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ClassRecursiveTask extends RecursiveTask<Integer>{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] ia; int from; int to; 
	public ClassRecursiveTask(int[] ia, int from, int to){ 
		this.ia = ia; 
		this.from = from; 
		this.to = to;
	} 
	protected Integer compute() { 
		if(from == to){ //Update the value using logic implemented somewhere else.    
			ia[from] = UtilityClass.utilityMethod(ia[from]); 
		}
		else{
			int mid = (from+to)/2; 
			ClassRecursiveTask newtask1 = new ClassRecursiveTask(ia, from, mid); 
			ClassRecursiveTask newtask2 = new ClassRecursiveTask(ia, mid+1, to); 
			newtask2.fork(); 
			newtask1.compute(); 
			newtask2.join(); 
		}
		return from; 
	}
	public static void main(String[] args) { 
		int ia[] = new int[]{ 1, 2, 3, 4 , 5, 6, 7};
		ForkJoinPool fjp = new ForkJoinPool();
		ClassRecursiveTask st = new ClassRecursiveTask(ia, 0, 6); 
		fjp.invoke(st); 
		System.out.print("New Array Values = "); 
		for(int i : ia) System.out.print(i+" ");
	}
}