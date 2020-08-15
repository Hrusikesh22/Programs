package creational.abstractfactory;

public class FactoryProvider {

	public static AbstractFactory getFactory(String choice){  

		switch(choice.toUpperCase()) {

		case "BANK" :
			return new BankFactory();  
		
		case "LOAN" :
			return new LoanFactory();  
		
		default : 
			return null;  

		}
	}  
}