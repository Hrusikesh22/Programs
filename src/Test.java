import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Alarm a1 = new Alarm(0, "A1");
		Alarm a2 = new Alarm(0, "A1");
		
		//System.out.println(a1.equals(a2));
		
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


