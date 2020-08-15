package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {

	public static void main(String[] s) throws InterruptedException {
		
		List<ThreadCls> tasks = new ArrayList<ThreadCls>();
		
		for(int i = 1 ; i <= 100; i++) {
			tasks.add(new ThreadCls(i));
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.invokeAll(tasks);
		executorService.shutdown();
	}
}


class ThreadCls implements Callable<Boolean> {
	
	/*volatile static AtomicInteger no = new AtomicInteger(0);*/
	int no;
	ThreadCls(int no) {this.no = no;}
	public Boolean call() {
		//no.incrementAndGet();
		System.out.println(Thread.currentThread() + "------>" + no);
		return true;
	}
}

