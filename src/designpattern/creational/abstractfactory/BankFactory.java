package designpattern.creational.abstractfactory;

class BankFactory extends AbstractFactory{  

	public Bank getBank(String bank){  
		if(bank == null)  
			return null;  

		switch(bank.toUpperCase()) {
		
		case "HDFC" :
			return new HDFC();  
		
		case "ICICI" :
			return new ICICI();  
		
		case "SBI" :
			return new SBI();  
		
		default :
			return null;  
		}
	}  

	public Loan getLoan(String loan) {  return null;  }  
}

//===============================================================================================

interface Bank{  
	String getBankName();  
} 

class HDFC implements Bank{  
	
	private final String bName;  

	public HDFC(){  
		bName="HDFC BANK";  
	}  

	public String getBankName() {  
		return bName;  
	}  
} 

class ICICI implements Bank{  
	
	private final String bName;  

	ICICI(){  
		bName="ICICI BANK";  
	}  

	public String getBankName() {  
		return bName;  
	}  
}  

class SBI implements Bank{  
	
	private final String bName;  

	public SBI(){  
		bName="SBI BANK";  
	}  

	public String getBankName(){  
		return bName;  
	}  
}  