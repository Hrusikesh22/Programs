package thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Wait/Notify/NotifyAll has to call on SAME OBJECT, for threads to interact/coordinate 
 *
 */

public class WaitNotifyAll_2 {

	private List<String> synchedList = Collections.synchronizedList(new LinkedList<String>());

	public String removeElement() throws InterruptedException {

		synchronized (synchedList) {//IMP: Lock object

			while (synchedList.isEmpty()) {
				
				System.out.println("List is empty... | " + Thread.currentThread().getName() + " will wait...");

				synchedList.wait();//Waited on syncedList
			}

			String element = synchedList.remove(0);

			System.out.println("'"+ element + "' Removed by " + Thread.currentThread().getName());
			return element;
		}
	}

	public void addElement(String element) {

		
		synchronized (synchedList) {//IMP: Lock object

			synchedList.add(element);

			System.out.println(Thread.currentThread().getName() + " Added Element...");

			synchedList.notifyAll();//Notified on syncedList
		}
		System.out.println("All notified !!!");
	}

	public static void main(String[] args) {

		final WaitNotifyAll_2 demo = new WaitNotifyAll_2();

		Runnable consumerRunnable = new Runnable () {

			public void run() {
				try {
					demo.removeElement();
				} 
				catch (InterruptedException ix) { System.out.println("Interrupted Exception!"); } 
				catch (Exception x) { System.out.println("Exception thrown."); }
			}
		};

		Thread producerThread = new Thread("Producer_Thread") {

			public void run() {
				demo.addElement("Hello!");
			}
		};

		try {
			Thread consumerThread1 = new Thread(consumerRunnable, "Consumer_Thread_1");
			consumerThread1.start();

			Thread.sleep(500);

			Thread consumerThread2 = new Thread(consumerRunnable, "Consumer_Thread_2");
			consumerThread2.start();

			Thread.sleep(500);

			producerThread.start();

			Thread.sleep(1000);

			consumerThread1.interrupt();
			consumerThread2.interrupt();
			
		} catch (InterruptedException x) {}
	}
}
