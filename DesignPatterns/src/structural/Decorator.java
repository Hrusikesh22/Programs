package structural;

public class Decorator {
	public static void main(String[] s) {
		Shape shape = new Circle();
		shape.draw();
		
		shape = new DecoratedCircle(new Circle());//Looks similar to Adapter Pattern, but purpose is not same. Translator vs Dynamic Functionality
		shape.draw();
	}
}

/*
 *								IShape
 *			----------------------------------------
 *			|										|
 * 		Plain_Con_Class					Decorator_Abstract_Class
 * 													|
 * 										Decorator_Concrete_Class(Plain_Conc_Class) : Interface						
 * 						
 *
 * Dynamically add functionality and behavior to an object without affecting the behavior of other existing objects in the same class.
 * i.e. The object which is required to have new behavior/functionality will be passed to Decorator. Rest of the object will behave normally.  
 */

interface Shape{
	public void draw();
}

class Circle implements Shape{
	public void draw(){
		System.out.println("Plain Circle...");
	}
}

class Rectangle implements Shape{
	public void draw(){
		System.out.println("Plain Rectangle...");
	}
}

abstract class A_Decorator implements Shape {
	Shape shape;
}

class DecoratedCircle extends A_Decorator {
	public DecoratedCircle(Shape shape) {
		super.shape = shape;
	}

	@Override
	public void draw() {
		System.out.println("\n-------------");
		shape.draw();
		System.out.println("Decorated ...");
		System.out.println("-------------");
		//Here or before draw functionality we can add any new Behavior/function.
	}
}

//Similarly can have DecoratedRectangle.