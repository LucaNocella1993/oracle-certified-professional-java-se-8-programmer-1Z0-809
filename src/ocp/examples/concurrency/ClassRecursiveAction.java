package ocp.examples.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ClassRecursiveAction extends RecursiveAction{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] ia; int from; int to; 
	public ClassRecursiveAction(int[] ia, int from, int to){ 
		this.ia = ia; 
		this.from = from; 
		this.to = to;
	} 
	protected void compute() { 
		if(from == to){ //Update the value using logic implemented somewhere else.    
			ia[from] = UtilityClass.utilityMethod(ia[from]); 
		}
		else{
			int mid = (from+to)/2; 
			ClassRecursiveAction newtask1 = new ClassRecursiveAction(ia, from, mid); 
			ClassRecursiveAction newtask2 = new ClassRecursiveAction(ia, mid+1, to); 
			newtask2.fork(); 
			newtask1.compute(); 
			newtask2.join(); 
		} 
	}
	public static void main(String[] args) { 
		int ia[] = new int[]{ 1, 2, 3, 4 , 5, 6, 7};
		ForkJoinPool fjp = new ForkJoinPool();
		ClassRecursiveAction st = new ClassRecursiveAction(ia, 0, 6); 
		fjp.invoke(st); 
		System.out.print("New Array Values = "); 
		for(int i : ia) System.out.print(i+" ");
	}
}  
class UtilityClass{ 
	public static int utilityMethod(int x) { 
		return x+1;
	}
}