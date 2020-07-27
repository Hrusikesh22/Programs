package collections.generics;

/*
 * https://www.youtube.com/watch?v=Gq0gGMokjJ8
 */
public class Generic_Class_And_Method {
	public static void main(String[] s) {
		max(21,  12);
		max("tutu", "jitu");
		
		System.out.println(new MyGenericClass1<String>("Hello", 22));
		System.out.println(new MyGenericClass2<Integer>(new Integer(11), 22));
	}
	
	/*
	 * GENERIC METHOD
	 * <T extends Comparable<T>> in method signature means, this method can use 
	 * 1) Only type T parameters
	 * 2) That type has to be a Comparable object (i.e. Must have to implement Comparable interface) 
	 * 
	 * IMP: Since 'T extends Comparable' and Comparable is an interface, T is literally has to be an Interface.
	 * So in real, T can be a Class/Interface 
	 */
	private static <T extends Comparable<T>> void max(T t1, T t2) {
		
		if(t1.compareTo(t2) > 0)
			System.out.println("Max("+t1+", "+t2+") = " + t1);
		else
			System.out.println("Max("+t1+", "+t2+") = " + t2);
	}
}

//NOTE: Both the generic class type declaration 'T' & 'T extends Comparable' looks similar as we are not required to compare 
//anything within these class as we have done in above generic method to find max. But actually not the same.
//First one is any type, irrespective of that type is comparable or not.
//Second one type has to be a comparable, else won't accept the type

//GENERIC CLASS Flavor 1
class MyGenericClass1<T> {
	T a;
	int b;
	
	public MyGenericClass1(T a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "MyGenericClass1 [ " + a + " " + b + " ]";
	}
}

//GENERIC CLASS Flavor 2
class MyGenericClass2<T extends Comparable<?>> {
	T a;
	int b;
	
	public MyGenericClass2(T a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "MyGenericClass1 [ " + a + " " + b + " ]";
	}
}
