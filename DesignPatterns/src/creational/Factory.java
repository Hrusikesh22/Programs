package creational;


/*
 * Read complete reference or Points at the bottom
 * https://javarevisited.blogspot.com/2011/12/factory-design-pattern-java-example.html
 */

/*
 * Factory client code
 */
public class Factory {
	public static void main(String args[]) {
		String country = args[0];
		
		Currency rupee = CurrencyFactory.createCurrency(country);//Object Creation
		
		System.out.println(rupee.getSymbol());
	}
}

/*
 * Factory Class code
 */
class CurrencyFactory {

	/*
	 * Static Factory Method
	 */
	public static Currency createCurrency (String country) {

		switch(country.toUpperCase()) {
		
		case "INDIA" : 
			return new Rupee(); 
		
		case "SINGAPORE" : 
			return new SGDDollar(); 
		
		case "US" : 
			return new USDollar();
		
		default : 
			throw new IllegalArgumentException("No such currency");
		}
	}
}

interface Currency {
	String getSymbol();
}

class Rupee implements Currency {
	
	@Override
	public String getSymbol() {
		return "Rs";
	}
}

class SGDDollar implements Currency {
	
	@Override
	public String getSymbol() {
		return "SGD";
	}
}

class USDollar implements Currency {
	
	@Override
	public String getSymbol() {
		return "USD";
	}
}

/*
 * Why Factory Methods ?
 * Providing Object creation responsibilities to a separate unit.
 * So less coupled and highly cohesive code, flexible and consistent manner of object creation.
 * Object creation is independent from client, object can be created in any suitable way. Let is be from a file, Data Source etc.  
 * 
 * 
 * 
 * 
 */



