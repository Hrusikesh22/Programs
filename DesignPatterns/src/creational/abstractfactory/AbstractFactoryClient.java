package creational.abstractfactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactoryClient {
	
	public static void main(String args[])throws IOException {  

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  

		System.out.print("Enter the name of Bank from where you want to take loan: ");  
		String bankName=br.readLine();  

		System.out.print("\nEnter the type of loan (e.g. home/business/education): ");  

		String loanName = br.readLine();  
		
		//FACTORY-1
		AbstractFactory bankFactory = FactoryProvider.getFactory("Bank");  
		
		Bank bank = bankFactory.getBank(bankName);  

		System.out.print("\nEnter the interest rate for "+ bank.getBankName()+ ": ");  

		double rate = Double.parseDouble(br.readLine());  
		System.out.print("\nEnter the loan amount you want to take: ");  

		double loanAmount = Double.parseDouble(br.readLine());  
		System.out.print("\nEnter the number of years to pay your entire loan amount: ");  
		int years = Integer.parseInt(br.readLine());  

		System.out.println("\nyou are taking the loan from "+ bank.getBankName());  

		//FACTORY-2
		AbstractFactory loanFactory = FactoryProvider.getFactory("Loan");  
		
		Loan loan = loanFactory.getLoan(loanName);  
		loan.getInterestRate(rate);  
		loan.calculateLoanPayment(loanAmount, years);  
	}  
}
