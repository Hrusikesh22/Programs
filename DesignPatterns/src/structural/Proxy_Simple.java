package structural;

public class Proxy_Simple {

	public static void main(String[] s) {
		Iface proxy = new ProxyClass();
		proxy.doSomething();
	}
}

interface Iface {
	public void doSomething();
}

class ConcreteClass implements Iface {

	public void doSomething() {
		System.out.println("Actual Concrete Class..");
	}
}

class ProxyClass extends ConcreteClass {

	public void doSomething() {
		System.out.println(" NOTE @Proxy :: "
				+ "Security check or "
				+ "Lazy loading Or "
				+ "some prerequisites are done. "
				+ "If passed, proceed below for actual behavior");
		super.doSomething();
	}
}

/*
 * 					Interface
 * 						|
 * 					Concrete_Class
 * 						|
 * 					Proxy_Class
 * 			
 * 	Client.Proxy();
 */