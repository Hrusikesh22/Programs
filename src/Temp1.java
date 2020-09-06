
public class Temp1 {

	public static void main(String[] s) {
		
		int i = fun1();

		System.out.println(i);
	}

	
	static int fun1() {
		
		System.out.println("fun1");
		

		//new Thread(()->{
			try {
				fun2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}).start();
		
		return 1;
	}

	static void fun2() throws InterruptedException {
		System.out.println("fun2");
		
		Thread.sleep(100);
		
		System.out.println("fun2");
		System.out.println("fun2");
	}
}
