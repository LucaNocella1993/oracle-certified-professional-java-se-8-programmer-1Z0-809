package ocp.examples.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceClass {
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
	public void planEvents() {
		service.scheduleWithFixedDelay(
				() -> System.out.print("Check food stock"),
				1, 1, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(
				() -> System.out.print("Check drink stock"),
				1, 1, TimeUnit.SECONDS);
		service.execute(() -> System.out.print("Take out trash"));
	}
	
	public static void main(String[] args) {
		ScheduledExecutorServiceClass c = new ScheduledExecutorServiceClass();
		c.planEvents();
	}
}

/*
RESOURCE STARVATION is when a single active thread is perpetually unable to gain
access to a shared resource. 

LIVELOCK is a special case of resource starvation, in which two or more active threads
are unable to gain access to shared resources, repeating the process over and over again.

DEADLOCK and livelock are similar, although in a deadlock situation the threads are
stuck waiting, rather than being active or performing any work.

RACE CONDITION is an undesirable result when two tasks that should be completed
sequentially are completed at the same time.
 */