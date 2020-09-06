import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws Exception {

		//System.out.println("null".equalsIgnoreCase("null"));
		
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.offer(10);
		q.offer(2);
		q.offer(15);
		q.offer(8);
		System.out.println("Q=" + q.peek());

		char ch = 'Z';
		System.out.println("char of 1 " + (int)ch);
		
		char[] chArr ="abcd".toCharArray();
		int i = (int)chArr[0];
		char[] A = new char[256];
		A[i]= 'a';
		/*for(char c : A) {
			System.out.println(c);
		}*/

		System.exit(0);

		//Map<String, String> cMap = new ConcurrentHashMap<String, String>();
		Map<String, String> cMap = new HashMap<String, String>();
		cMap.put("key", "value");
		for(String key : cMap.keySet()) {
			cMap.put(key, "value_");
			cMap.remove(key);
			cMap.put("Key2", "value_2");
		}
		System.out.println("map size " + cMap.size());

		new B();

		Set<?> setOfUnknownType = new LinkedHashSet<String>();
		setOfUnknownType = new LinkedHashSet<Integer>();


		Set<? super B> set1 = new HashSet<B>(); //OK
		set1 =  new HashSet<A>();//OK
		//set1.add(new A());//KO 
		set1.add(new B());//OK

		Set<?> set = new HashSet();
		//set = new HashSet<B>();

		//set.add(new Object());//KO
		//set.add(new A());

		//set2.add(new A());
		//set2.add(new B());
	}

	public static void method1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2);
	}

	public static void method2(List<?> list) {

	}

	public static void insertElements(){
		List<? extends A> list = new ArrayList<>();
		//list.add(new A());
		//list.add(new B());
		//list.add(new Object());
	}

}
class A{
	A(){
		System.out.println("A");
	}

}

class B extends A {
	B(){
		super();
		System.out.println("B");
	}
}

class Alarm {

	int id;
	String name;

	Alarm(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;

		System.out.println("CALLED :: HASHCODE -" + result);

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		System.out.println("CALLED :: EQUALS");

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Alarm)) {
			return false;
		}
		Alarm other = (Alarm) obj;
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}


}


