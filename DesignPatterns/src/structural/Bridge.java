package structural;

/**
 * Wiki : "Decouple an abstraction from its implementation so that the two can vary independently"
 */
public class Bridge {
	
	//"Preferring composition over inheritance"
	
}

/*
 * Implementation details are pushed from a hierarchy to another object(as 'HAS A') with a separate hierarchy.
 *
 * 									Shape
 * 					-------------------------------------
 * 					|								  	|
 * 			   	Rectangle					  		  I_Circle
 * 					|							 		|
 *			-----------------					 ----------------
 *			|				 |					 |				|
 *		Blue_Rectangle    Red_Rectangle		Blue_Circle		Red_Circle
 *
 * If you want to change Rectangle class, then you may end up changing BlueRectangle and RedRectangle as well.
 * And even if change is color specific then you may need to change Circle classes as well.
 * 
 * 				Shape											Color
 * 			-------------------------						-------------------
 * 			|						|						|				   |					
 * 		Rectangle(c:Color)		Circle(c:Color)			   Blue			   	  Red
 */