package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @since 18/08/2020
 * 
 * ExecutorService service = Executors.newFixedThreadPool(3);
 * 		
 * 		service.execute(Runnable)
 * 		service.submit(Callable) 
 * 		service.invokeAll(Callable-List) 
 */
public class MultiThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread(()->{
			Process.start();
		}).start();
		
		System.out.println("========= Main() START =========>");
		Thread.sleep(10);
		
		for(int i = 1; i <= 500; i++) {
			if(i%50==0)System.out.println();
			System.out.print(i +" ");
		}
		System.out.println("\n========= Main() END =========>");
	}
	
}

interface Processor{} //Marker Interface

class RunnableProcessor implements Runnable, Processor {
	
	int i = 0; 
	
	public RunnableProcessor(int i) {
		this.i = i;
	}
	
	@Override
	public void run() {
		System.out.println("\n" + Thread.currentThread() + " :: RunnableProcessor-"+i);
		System.out.println("\n" + Thread.currentThread() + " :: RunnableProcessor-"+i);
	}
}

class CallableProcessor implements Callable<Boolean>, Processor {
	
	int i = 0; 
	
	public CallableProcessor(int i) {
		this.i = i;
	}
	
	@Override
	public Boolean call() throws Exception {
		System.out.println("\n" + Thread.currentThread() + " :: CallableProcessor-"+i);
		System.out.println("\n" + Thread.currentThread() + " :: CallableProcessor-"+i);
		return true;
	}
}

class Process {
	
	public static void start() {
	
		ExecutorService service = Executors.newFixedThreadPool(3);

		List<CallableProcessor> callableProcessors = new ArrayList<CallableProcessor>();
		for(int i = 0; i < 3 ; i++ ) {
			service.execute(new RunnableProcessor(i+1)); //3 tasks in loop one by one
			service.submit(new CallableProcessor(i+1)); //3 tasks in loop one by one
			
			CallableProcessor callableProcessor = new CallableProcessor(i+1);
			callableProcessors.add(callableProcessor);
		}
		
		
		try {
			service.invokeAll(callableProcessors);//3 tasks
		} catch(InterruptedException ie) {
			
		} finally {
			service.shutdown(); //Must @end of process to terminate service
		}
		
		System.out.println("===================> END OF PROCESS");
	}
}

