package java8.iface;

interface Iface {

	default void print(String str) {
		if (!isNull(str)) {
			System.out.println("MyData Print::" + str);
		}
	}

	default boolean isNull(String str) {
		System.out.println("Iface:isNull()");

		return (str == null) ? true : ("".equals(str) ? true : false);
	}
}


public class IfaceImpl implements Iface {

	public boolean isNull(String str) {
		System.out.println("IfaceImpl:isNull()");

		return str == null ? true : false;
	}
	
	public static void main(String args[]){
		IfaceImpl obj = new IfaceImpl();
		//obj.print("");
		System.out.println(obj.isNull("abc"));
		
	}
}



