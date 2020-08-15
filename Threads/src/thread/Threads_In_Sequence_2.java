package thread;

public class Threads_In_Sequence_2 {

	public static void main(String[] args) {
		
		AA a = new AA();//Common Object

		new Thread(new Thread1(a), "Thread_1").start();
		new Thread(new Thread2(a), "Thread_2").start();
		new Thread(new Thread3(a), "Thread_3").start();
	}
}

class AA {
	int threadNo = 1;
	int counter = 1;
}

class Thread1 implements Runnable {

	private AA a;

	Thread1(AA a) {
		this.a = a;
	}

	@Override
	public void run() {
		synchronized (a) {
			while(a.counter<=9) {
				if(a.threadNo == 1) {
					System.out.println("-------> " + Thread.currentThread().getName());
					a.threadNo = 2;
					++a.counter;
					
					a.notifyAll();
					
				} else {
					try {
						a.wait();
					} catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}			
	}
}

class Thread2 implements Runnable {

	private AA a;

	Thread2(AA a) {
		this.a = a;
	}

	@Override
	public void run() {
		synchronized (a) {
			while(a.counter<=9) {
				if(a.threadNo == 2) {
					System.out.println("-------> " + Thread.currentThread().getName());
					a.threadNo = 3;
					++a.counter;
					
					a.notifyAll();
					
				} else {
					try {
						a.wait();
					} catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}			
	}
}

class Thread3 implements Runnable {

	private AA a;

	Thread3(AA a) {
		this.a = a;
	}

	@Override
	public void run() {
		synchronized (a) {
			while(a.counter<=9) {
				if(a.threadNo == 3) {
					System.out.println("-------> " + Thread.currentThread().getName());
					a.threadNo = 1;
					++a.counter;
					
					a.notifyAll();
					
				} else {
					try {
						a.wait();
					} catch (InterruptedException e) { e.printStackTrace(); }
				}
			}
		}			
	}
}