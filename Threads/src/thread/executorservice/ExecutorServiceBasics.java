package thread.executorservice;

public class ExecutorServiceBasics {

	/**
	 *  ExecutorService exService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, Unbounded_workQueue)
	 * 	                			Executors.newFixedThreadPool(3);
	 * 	                			Executors.newSingleThreadExecutor();
	 * 	                			Executors.newCachedThreadPool(3);
	 * corePoolSize : Minimum threads to maintain in pool even if "idle" without any task to execute.
	 * maxPoolSize	: If workQueue is full and all threads (i.e. corePoolSize) are in use, pool automatically adds/creates thread up to maxPoolSize.
	 * keepAliveTime: When no_of_active_thread greater than core size and lesser than max size, that is few extra threads are there. Those extra threads
	 * 				  will remain alive/wait till this much time for new task to arrive in Q else shut them down. 
	 * unit			: TimeUnit.MILLISECONDS
	 * 		
	 * 		service.execute(Runnable)
	 * 		service.submit(Runnable) 
	 * 		service.submit(Callable) 
	 * 		service.submit(Callable, returnResultType) 
	 * 		service.invokeAll(Callable-List) 
	 */
	
	/**
	 * submit vs execute
	 * -----------------
	 * EXECUTE simply starts the task without any further ado.
	 * 
	 * SUBMIT returns a FUTURE object to manage the task. 
	 * 
	 * You can do the following things with the FUTURE object:
	 * CANCEL the task prematurely, with the cancel method.
	 * Wait for the task to finish executing, with "get".
	 * The Future interface is more useful if you submit a Callable to the pool. The return value of the call method will be returned when you call "Future.get". 
	 * If you don't maintain a reference to the Future, there is no difference.
	 */
	
	/**
	 *  Bounded vs UnBounded Q
	 *  ----------------------
	 *  Bounded by capacity that is to provide max_size of the queue at the time of creation. 
	 *  e.g. ArrayBlockingQueue 
	 *  Unbounded are NOT bounded by capacity that means no need to provide the size.
	 */
	
	/**
	 * CachedThreadPool vs FixedThreadPool vs ThreadPoolExecutor
	 * ----------------    ---------------    ------------------
	 * https://www.baeldung.com/java-executors-cached-fixed-threadpool [MUST READ]
	 * https://www.tutorialspoint.com/java_concurrency/concurrency_newcachedthreadpool.htm [NICE EXAMPLE TO UNDERSTAND THE CACHING MECHANISM]
	 * 
	 * newCachedThreadPool:
	 * -------------------
	 * creates thread pool. When thread is needed, it returns a thread from CACHE(60sec/1min of thread life in cache by default) and if not available, a new thread is created for a short time.
	 * Good n Bad is nice explained in baeldung.com
	 * 
	 * 
		1.> Overview
		------------
		When it comes to thread pool implementations, the Java standard library provides plenty of options to choose from. The fixed and cached thread pools are pretty ubiquitous among those implementations.
		
		In this tutorial, we're going to see how thread pools are working under the hood and then compare these implementations and their use-cases.
		
		2.> Cached Thread Pool
		----------------------
		Let's take a look at how Java creates a cached thread pool when we call Executors.newCachedThreadPool():
		
		public static ExecutorService newCachedThreadPool() {
		    return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, 
		      new SynchronousQueue<Runnable>());
		}
		Cached thread pools are using “synchronous handoff” to queue new tasks. The basic idea of synchronous handoff is simple and yet counter-intuitive: One can queue an item if and only if another thread takes that item at the same time. In other words, the SynchronousQueue can not hold any tasks whatsoever.
		
		Suppose a new task comes in. If there is an idle thread waiting on the queue, then the task producer hands off the task to that thread. Otherwise, since the queue is always full, the executor creates a new thread to handle that task.
		
		The cached pool starts with zero threads and can potentially grow to have Integer.MAX_VALUE threads. Practically, the only limitation for a cached thread pool is the available system resources.
		
		To better manage system resources, cached thread pools will remove threads that remain idle for one minute.
		
		2.1.> Use Cases
		---------------
		The cached thread pool configuration caches the threads (hence the name) for a short amount of time to reuse them for other tasks. As a result, it works best when we're dealing with a reasonable number of short-lived tasks. 
		
		The key here is “reasonable” and “short-lived”. To clarify this point, let's evaluate a scenario where cached pools aren't a good fit. Here we're going to submit one million tasks each taking 100 micro-seconds to finish:
		
		Callable<String> task = () -> {
		    long oneHundredMicroSeconds = 100_000;
		    long startedAt = System.nanoTime();
		    while (System.nanoTime() - startedAt <= oneHundredMicroSeconds);
		 
		    return "Done";
		};
		 
		var cachedPool = Executors.newCachedThreadPool();
		var tasks = IntStream.rangeClosed(1, 1_000_000).mapToObj(i -> task).collect(toList());
		var result = cachedPool.invokeAll(tasks);
		This is going to create a lot of threads that translate to unreasonable memory usage, and even worse, lots of CPU context switches. Both of these anomalies would hurt the overall performance significantly.
		
		Therefore, we should avoid this thread pool when the execution time is unpredictable, like IO-bound tasks.
		
		3.> Fixed Thread Pool
		---------------------
		Let's see how fixed thread pools work under the hood:
		
		public static ExecutorService newFixedThreadPool(int nThreads) {
		    return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, 
		      new LinkedBlockingQueue<Runnable>());
		}
		As opposed to the cached thread pool, this one is using an unbounded queue with a fixed number of never-expiring threads. Therefore, instead of an ever-increasing number of threads, the fixed thread pool tries to execute incoming tasks with a fixed amount of threads. When all threads are busy, then the executor will queue new tasks.  This way, we have more control over our program's resource consumption.
		
		As a result, fixed thread pools are better suited for tasks with unpredictable execution times.
		
		4.> Unfortunate Similarities
		----------------------------
		So far, we've only enumerated the differences between cached and fixed thread pools.
		
		All those differences aside, they're both use AbortPolicy as their saturation policy. Therefore, we expect these executors to throw an exception when they can't accept and even queue any more tasks.
		
		Let's see what happens in the real world.
		
		Cached thread pools will continue to create more and more threads in extreme circumstances, so, practically, they will never reach a saturation point. Similarly, fixed thread pools will continue to add more and more tasks in their queue. Therefore, the fixed pools also will never reach a saturation point.
		
		As both pools won't be saturated, when the load is exceptionally high, they will consume a lot of memory for creating threads or queuing tasks. Adding insult to the injury, cached thread pools will also incur a lot of processor context switches.
		
		Anyway, to have more control over resource consumption, it's highly recommended to create a custom ThreadPoolExecutor:
		
		var boundedQueue = new ArrayBlockingQueue<Runnable>(1000);
		new ThreadPoolExecutor(10, 20, 60, SECONDS, boundedQueue, new AbortPolicy());
		Here, our thread pool can have up to 20 threads and can only queue up to 1000 tasks. Also, when it can't accept any more load, it will simply throw an exception.
		
		5.> Conclusion
		--------------
		In this tutorial, we had a peek into the JDK source code to see how different Executors work under the hood. Then, we compared the fixed and cached thread pools and their use-cases.
		
		In the end, we tried to address the out-of-control resource consumption of those pools with custom thread pools.
*/
	
}
