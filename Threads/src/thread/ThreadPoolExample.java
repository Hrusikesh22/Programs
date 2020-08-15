package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample implements Runnable {
  
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start.");
        process();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void process() {
    	 System.out.println("Processing happens here !!!");
    }

    
    /**
     * Test Method or Start of application/processing
     * @param args
     */
    public static void main(String[] args) {
    	String metricIndex = "*aaa*";
    	System.out.println(metricIndex.endsWith("*")? metricIndex.substring(0, metricIndex.length()-1) : metricIndex);
    	/*//Creating a pool of 5 threads.
    	ExecutorService executor = Executors.newFixedThreadPool(5);
    	
    	//Submitting 10 Tasks
    	for (int i = 0; i < 10; i++) {
    		Runnable task = new ThreadPoolExample();
    		executor.execute(task);
    	}
    	
    	//Shutting down the service or pool
    	executor.shutdown();

    	while (!executor.isTerminated()) {
    	}
    	System.out.println("Finished all threads");*/
    }
}
