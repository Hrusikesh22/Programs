package thread;

public class WaitNotify {
	public static void main(String[] s) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		
		t1.setB(t2);

		new Thread(t1).start();
		new Thread(t2).start();
	}
}

class T1 implements Runnable {

	T2 t2;//Imp to have a B reference upon which wait is called.

	void setB(T2 b){
		this.t2 = b;
	}

	@Override
	public void run() {

		synchronized (t2) {//locked on t2
			System.out.println(" T1 waited and will resume once T2 notifies !!!");
			try {
				//if() //Associate wait call with some condition (Good Practice). Check producer consumer.
				t2.wait();

				System.out.println(" T1's wait is over. Now T1 is completed !!!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class T2 implements Runnable {

	@Override
	public void run() {

		synchronized (this) {//locked on t2
			for(int i = 1; i<= 5; i++ )
				System.out.println("----- T2 "+i+" ------");

			notify();//calling on this/t2 Object
		}
	}
}

/*
 * Keep a reference of T2 in T1 to put lock and call wait on it. 
 * wait/notify has to be within synchronized block or else IllegalMonitorStateException
 */