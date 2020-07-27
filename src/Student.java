import java.io.Serializable;
import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Student implements Serializable {
	
	private static final long serialVersionUID = 6238564194001146189L;
	
	@JsonProperty("name_id")
	@SerializedName("name_id")
	private String name;
	private int age;
	
	boolean boolTest;
	
	public Student() {}
	
	public Student(String name, int age) {
		this.name = name;
		this.id = age;
	}
	
	public String getName() {
		return name;
	}

	//@JsonProperty("name")
	//@SerializedName("name_id")
	public void setName(String name) {
		this.name = name+"_$$$$$";
		System.out.println("------ Setter Called ----".toUpperCase());
	}
	public int getAge() {
		return id;
	}
	public void setAge(int age) {
		this.id = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + id + "]";
	}

	public static Comparator<Alarm> sortByName = new Comparator<Alarm>() {
		
		@Override
		public int compare(Alarm o1, Alarm o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	public static Comparator<Alarm> sortByAge = new Comparator<Alarm>() {
		
		@Override
		public int compare(Alarm o1, Alarm o2) {
			return Long.valueOf(o1.getAge()).compareTo(Long.valueOf(o2.getAge())) * -1;
		}
	}; 
}