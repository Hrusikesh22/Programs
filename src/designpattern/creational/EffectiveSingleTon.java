package designpattern.creational;

class SingletonClz {
	
	private SingletonClz() {
		System.out.println("- PRIVATE CONSTRUCTOR -");
	}
	
	public static SingletonClz getInstance() {
		return SingletonClzHolder.singleInstance;
	}

	//PRIVATE Inner/Holder class
	private static class SingletonClzHolder {
		private static SingletonClz singleInstance = new SingletonClz();
	}
	
}

/*
 * Testing Singleton
 */
public class EffectiveSingleTon {
	
	public static void main(String[] s) {

		new Thread(() -> {
			System.out.println(Thread.currentThread() + " ==> " + SingletonClz.getInstance());
		}).start();
		new Thread(() -> {
			System.out.println(Thread.currentThread() + " ==> " + SingletonClz.getInstance());
		}).start();
		new Thread(() -> {
			System.out.println(Thread.currentThread() + " ==> " + SingletonClz.getInstance());
		}).start();
	}
}
