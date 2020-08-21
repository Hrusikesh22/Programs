package thread;

import java.util.concurrent.CountDownLatch; 
/**
 * 
 * @since 19/8/2020
 * Used to make sure that a task/thread waits for other threads/tasks before it starts
 *
 */
public class CountDownLatchTest {

	public static void main(String args[]) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(4);// Let us create task that is going to wait for 4 threads before it starts 

		//Let us create four worker threads and start them. 
		Worker first = new Worker(1000, latch, "WORKER-1"); 
		Worker second = new Worker(2000, latch, "WORKER-2"); 
		Worker third = new Worker(3000, latch, "WORKER-3"); 
		Worker fourth = new Worker(4000, latch, "WORKER-4"); 
		
		first.start(); second.start(); third.start(); fourth.start(); 

		// The main task waits for four threads 
		latch.await(); 

		// Main thread has started 
		System.out.println(Thread.currentThread().getName() + " has finished"); 
	} 
} 

class Worker extends Thread { 
	
	private int delay; 
	private CountDownLatch latch; 

	public Worker(int delay, CountDownLatch latch, String name) { 
		super(name); 
		this.delay = delay; 
		this.latch = latch; 
	} 

	@Override
	public void run() { 
		
		try { 
			Thread.sleep(delay); 
			
			System.out.println(Thread.currentThread().getName() + " finished"); 

			latch.countDown(); 
		} 
		catch (InterruptedException e) { e.printStackTrace(); } 
	} 
} 

/*
	O/P:
	WORKER-1 finished
	WORKER-2 finished
	WORKER-3 finished
	WORKER-4 finished
	main has finished

*/