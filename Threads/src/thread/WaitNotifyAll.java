package thread;

public class WaitNotifyAll {

	public static void main(String[] args) throws InterruptedException {
		Cook cook = new Cook();

		Thread waiter1 = new Thread(new Waiter(cook), "Waiter-1");
		Thread waiter2 = new Thread(new Waiter(cook), "Waiter-2");
		Thread waiter3 = new Thread(new Waiter(cook), "Waiter-3");
		
		waiter1.start(); waiter2.start(); waiter3.start();
		
		Thread.sleep(1000);
		
		new Thread(cook).start();
	}
}

class Waiter implements Runnable {

	private Cook cook;
	
	Waiter(Cook cook){ this.cook = cook;}
	
	@Override
	public void run() {
		
		synchronized(cook) {
			
			System.out.println(Thread.currentThread().getName() + " waiting for " + cook);
			
			try {
				cook.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " notified by " + cook);
		}
	}
	
}

class Cook implements Runnable {

	@Override
	public void run() {
		synchronized (this) {

			System.out.println("Cook started..........");
			
			/*try {//Put some halt so that all the waiters can submit order (i.e. Thread execution started)
				Thread.sleep(30000);
			} catch (InterruptedException e) { e.printStackTrace(); }*/
			//SLEEP won't serve this purpose, as it will not release lock. Rather we will use loop.
			
			/*int total = 0;
			for(int i = 0; i< 1000; i++) total += i;*/
			//THIS LOOP IS ALSO NOT USEFUL. NEED TO PUT SLEEP IN MAIN(), CHECKOUT.
			
			System.out.println("Cook completes. Notifying ......");
			this.notifyAll();
		}
	}
	
}