package Utilities.thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadTest {

	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			Process.start();
		}).start();
		for(int i = 0; i < 500; i++) {
			System.out.println("THE END - " + i);
		}
	}
	
}

class Processor implements Callable<Boolean> {
	
	@Override
	public Boolean call() throws Exception {
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread());
		return true;
	}
}

class Process {
	public static void start() {
		List<Processor> processors = new ArrayList<Processor>();
		for(int i = 0; i < 3 ; i++ ) {
			//service.execute(new Processor(i+1));
			Processor processor = new Processor();
			processors.add(processor);
			//System.out.println("T" + (i+1) + " :: Thread Started already !!! Now - "  + new Date());
		}
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		try {
			service.invokeAll(processors);
		} catch(InterruptedException ie) {
			
		} finally {
			service.shutdown();
		}
		
		System.out.println("===================> END OF PROCESS");
	}
}

