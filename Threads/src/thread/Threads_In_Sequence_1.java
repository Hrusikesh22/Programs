package thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://stackoverflow.com/questions/12989397/running-3-threads-in-sequence-java
 */
public class Threads_In_Sequence_1 {
	
	public static void main(String[] args) throws IOException {
		
		Thread t1 = new Thread(new A(), "1");
		Thread t2 = new Thread(new A(), "2");
		Thread t3 = new Thread(new A(), "3");

		t1.start();
		try{
			t1.join();//Joins current thread (i.e. Main) at the end(once finishes/dies) of t1
		}catch (Exception e){}
		
		t2.start();
		try{
			t2.join();
		}catch (Exception e){}
		
		t3.start();
		try{
			t3.join();
		}catch (Exception e){}
	}
}

class A implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " : " + 
							Thread.currentThread().getName());
	}
}

