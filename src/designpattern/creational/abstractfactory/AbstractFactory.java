package designpattern.creational.abstractfactory;

/*
 * Factory of Factories
 */

abstract class AbstractFactory{  
	  public abstract Bank getBank(String bank);  
	  public abstract Loan getLoan(String loan);  
	}  
