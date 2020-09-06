package arrays;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Use BigInteger+multiply()
 */
public class Factorical_LargeNumber {

	public static void main(String arg[]) 
	{ 
		BigInteger bigInt = new BigInteger("1"); //Important to use BI for large number to store.

		Scanner kb = new Scanner(System.in); 
		System.out.println("Enter number to find factorial:- "); 
		int no = kb.nextInt(); 

		for(int i = 2; i <= no; i++) { 
			bigInt = bigInt.multiply(BigInteger.valueOf(i)); //IMP: multiply method.
		} 
		
		System.out.println(bigInt); 
	} 
}
