package creational;

/*
 * For large number of parameters...
 * 
 * 1-STATIC FACTORY or CONSTURCTORS are not good.
 * 2-TELESCOPING CONSTRUCTOR PATTERN (Multiple constructors with only specific set of required parameters) is
 *   harder to read/write such code for Client
 * 3-JAVA BEAN PATTERN (No Arg constructor and then setter methods) 
 *   a - will impose multiple/split call for a single instance construction
 *   b - class can't be IMMUTABLE
 *   c -  Requires extra effort to ensure THREAD SAFETY.
 * 
 *  Solution - BUILDER PATTERN
 *  - Shot of mix between Telescoping + JavaBean pattern.
 */
public class Builder {

	public static void main(String[] s) {
		
		Student student = new Student.StudentBuilder(1, "Student-1")
									.setAge(14)
									.setAddress("Hyd")
									.setPhoneNo("5689797979")
									.build();
		
		System.out.println(student);
	}
}

class Student {

	int id, age; 
	String name, address, standard, phoneNo;
	float height, weight;

	//Private
	private Student(StudentBuilder builder) {
		super();
		this.id = builder.id;
		this.age = builder.age;
		this.name = builder.name;
		this.address = builder.address;
		this.standard = builder.standard;
		this.phoneNo = builder.phoneNo;
		this.height = builder.height;
		this.weight = builder.weight;
	}

	public static class StudentBuilder {

		/* Required/Essential/Compulsory Parameters has to be passed by Client and will be set with that*/
		private int id; 
		private String name;

		/* Rest of the parameters with their default values */
		private int age = 0; 
		private String address = "-";
		private String standard = "-";
		private String phoneNo = "-";
		private float height = 0;
		private  float weight = 0;

		//Builder/Inner class constructor
		public StudentBuilder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		/* Rest of parameters are optional, to be set if passed */
		/* IMP : They must return this/StudentBuilder instance */ 

		public StudentBuilder setAge(int age) {
			this.age = age; return this;
		}

		public StudentBuilder setAddress(String address) {
			this.address = address; return this;
		}

		public StudentBuilder setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo; return this;
		}

		/* IMP : Actual object will be constructed on build() method call*/ 
		public Student build() {
			return new Student(this);
		}
	}
}

/*
* Student.StudentBuilder() creating instance of inner class i.e. Builder
* 1st Create an instance of inner_static/Builder class with most required parameters.
* set optional parameters though setter on this Builder class.
* finally call Builder.build method like Builder().setXXX().setYYY().build() which will create actual object.
*/