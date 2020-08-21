package thread.executorservice;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewCachedThreadPool {

	public static void main(final String[] arguments) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();

		// Cast the object to its class type
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

		//Stats before tasks execution
		System.out.println("Largest executions: "+ pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads: " + pool.getMaximumPoolSize());
		System.out.println("Current threads in pool: " + pool.getPoolSize());
		System.out.println("Currently executing threads: " + pool.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + pool.getTaskCount());

		executor.submit(new Task());
		executor.submit(new Task());

		//Stats after tasks execution
		System.out.println("Core threads: " + pool.getCorePoolSize());
		System.out.println("Largest executions: " + pool.getLargestPoolSize());
		System.out.println("Maximum allowed threads: "+ pool.getMaximumPoolSize());
		System.out.println("Current threads in pool: "+ pool.getPoolSize());
		System.out.println("Currently executing threads: "+ pool.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + pool.getTaskCount());

		executor.shutdown();
	}  

	static class Task implements Runnable {

		public void run() {

			try {
				Long duration = (long) (Math.random() * 5);
				System.out.println("Running Task! Thread Name: " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(duration);
				System.out.println("Task Completed! Thread Name: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
    O/P:
	Largest executions: 0
	Maximum allowed threads: 2147483647
	Current threads in pool: 0
	Currently executing threads: 0
	Total number of threads(ever scheduled): 0
	Core threads: 0
	Largest executions: 2
	Maximum allowed threads: 2147483647
	Current threads in pool: 2
	Currently executing threads: 2
	Total number of threads(ever scheduled): 2
	Running Task! Thread Name: pool-1-thread-1
	Running Task! Thread Name: pool-1-thread-2
	Task Completed! Thread Name: pool-1-thread-1
	Task Completed! Thread Name: pool-1-thread-2
 */