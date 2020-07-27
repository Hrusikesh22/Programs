package thread;
public class MyThread extends AbstrctClass implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread());
		abstrctClzProtectedMember++;
		abstrctClzProtectedMethod();
	}

}
