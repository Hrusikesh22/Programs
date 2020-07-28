package designpattern.creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * When object creation is expensive/heavy compared to cloning
 * To avoid building a class hierarchy of factories that parallels the class hierarchy of products
 * When instances of a class can have one of only a few different combinations of state
 */
public class Prototype {
	
	public static void main(String[] args) throws IOException {  
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));  
        
        System.out.print("Enter Employee Id: ");  int eid=Integer.parseInt(br.readLine());  
        System.out.print("\n Enter Employee Name: ");  String ename=br.readLine();  
        System.out.print("\nEnter Employee Designation: ");  String edesignation=br.readLine();  
        System.out.print("\nEnter Employee Address: ");  String eaddress=br.readLine();  
        System.out.print("\nEnter Employee Salary: ");  double esalary= Double.parseDouble(br.readLine());  

        EmployeeRecord e1 = new EmployeeRecord(eid,ename,edesignation,esalary,eaddress);  
          
        EmployeeRecord e2=(EmployeeRecord) e1.getClone(); 
        //NOTE: Once copy/prototype is ready, can change any specific attribute.
    } 
}

interface IClonable {  
	public IClonable getClone();  
}

class EmployeeRecord implements IClonable{  

	private int id;  
	private String name, designation;  
	private double salary;  
	private String address;  


	public  EmployeeRecord(int id, String name, String designation, double salary, String address) {  

		System.out.println("   Employee Records");  
		System.out.println("---------------------");  
		System.out.println("Eid"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"Esalary"+"\t\t"+"Eaddress");   
		
		this.id = id;  this.name = name;  
		this.designation = designation;  this.salary = salary;  this.address = address;  

		System.out.println(id+"\t"+name+"\t"+designation+"\t"+salary+"\t"+address + "\n");
	}  

	@Override  
	public IClonable getClone() {  

		return new EmployeeRecord(id,name,designation,salary,address);  
	}  
}


