package designpattern.creational.abstractfactory;

class LoanFactory extends AbstractFactory {  


	public Loan getLoan(String loan){  

		if(loan == null) 
			return null;  

		switch(loan.toUpperCase()) {

		case "HOME" :
			return new HomeLoan();  

		case "BUSINESS" :
			return new BussinessLoan();  

		case "EDUCATION" :
			return new EducationLoan();  

		default :
			return null;  
		}
	}  

	public Bank getBank(String bank){  return null;  }  
}  

//==================================================

abstract class Loan{  
	protected double rate;  
	abstract void getInterestRate(double rate);  
	public void calculateLoanPayment(double loanamount, int years)  
	{  
		double EMI;  
		int n;  

		n=years*12;  
		rate=rate/1200;  
		EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;  

		System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanamount+" you have borrowed");     
	}
}

class HomeLoan extends Loan{  
	public void getInterestRate(double r){  
		rate=r;  
	}
}

class BussinessLoan extends Loan{  
	public void getInterestRate(double r){  
		rate=r;  
	}
}

class EducationLoan extends Loan{  
	public void getInterestRate(double r){  
		rate=r;  
	}  
}
