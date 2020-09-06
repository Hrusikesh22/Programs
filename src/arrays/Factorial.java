package arrays;

public class Factorial {
	static int no = 10;
	public static void main(String[] s) {

		findFactorial(no);
		System.out.println("Recursive fact : " + factRecursive(no));
		System.out.println("\nRecursive fact(DP) : " + factRecursiveDP(no));
		
		System.out.println("\nMemoization in Effect now :)");
		System.out.println("Recursive fact(DP) : " + factRecursiveDP(no+1));
		
	}
	
	static void findFactorial(int no) {
		if(no == 0) {
			System.out.println("factorical of " + no + " = " + 1);
			return;
		}
		int i = no;
		int factorial = 1;
		while(no > 0) {
			factorial *= no--;
		}
		System.out.println("factorical of " + i + " = " +factorial);
	}
	
	static int factRecursive(int no) {
		if(no == 0 || no == 1) return 1;
		
		return no * factRecursive(no-1);
	}

	static int[] factArr = new int[no+2];
	
	/**
	 * Below won't make any difference if called for first time.
	 * From second time onwards for a number, we have cached in.
	 * So it's not actually DP, rather Cached in.
	 */
	static int factRecursiveDP(int no) {
		
		
		if(factArr[no] != 0) return factArr[no];
		
		if(no == 0 || no == 1) {
			factArr[no] = 1;
			return 1;
		}
		
		factArr[no] = no*factRecursiveDP(no-1);

		System.out.println();
		for(int aVal : factArr)System.out.print(aVal + " ");
		
		return factArr[no];
		
	}
}
