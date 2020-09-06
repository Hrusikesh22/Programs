package arrays;
/**
 * gcd(a,b,c) = gcd(a,gcd(b,c))
 * Similarly a, b, c can be exchanged.
 */
public class GCD_Of_Array {

	public static void main(String[] args) {
		int[] A = {999, 99, 9};
		System.out.println(findGCD(A));
	}

	static int findGCD(int[] A) {
		
		int gcd = A[0];
		
		for(int i : A)
			gcd = gcd(gcd, i);
		
		return gcd;
	}
	
	static int gcd(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}

/*
* Idea or Example
* Ex-1
* GCD of 12, 3
* Now pair is {12, 3} so 12%3 = 0, so 3 is the gcd
* Ex-2
* GCD of 6, 4
* 6%4=2
* now 4, 2 ==> 4%2=0, so 2 is the gcd
*/