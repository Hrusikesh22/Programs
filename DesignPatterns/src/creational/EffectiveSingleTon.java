package creational;

import java.io.Serializable;

class SingletonClz implements Serializable {
	
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
	
	//IMP: To resolve problem with de-serialization 
	private Object readResolve() {
		SingletonClz instance = getInstance();
	    return instance;
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
