package thread;
/**
 * Thread1 Lock Sequence (A, then B)
 * Thread2 Lock Sequence (B, then A)
 * Above results a deadlock. 
 * To avoid deadlock, lock sequence in both the thread has to be same i.e. A then B or B then A for both the threads.
 */
public class Deadlock {

	static ResourceA resourceA = new ResourceA();
	static ResourceB resourceB = new ResourceB();

	public static void main(String[] s) {
		
		Thread T1 = new Thread("T1") {
			public void run() {
				synchronized(resourceA) {
					System.out.println("T1 locked on ResourceA...");
					//Adding delay so that both threads can start trying to lock resources
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized (resourceB) {
						System.out.println("T1 has lock on ResourceA, then ResourceB");
					}
				}
			}
		};

		Thread T2 = new Thread("T2") {
			public void run() {
				synchronized(resourceB) {
					System.out.println("T2 locked on ResourceB...");
					synchronized (resourceA) {
						System.out.println("T1 has lock on ResourceB, then ResourceA");
					}
				}
			}
		};

		T1.start();
		T2.start();
	}
}

class ResourceA{
	//Write some code here
}

class ResourceB {
	//Write some code here
}