package sorting;

public class Utils {
	
	/**
	 * 
	 * @param A
	 * @param j
	 * @param jPlus1
	 */
	public static void swap( int[] A, int j, int jPlus1) {
		
		int temp = A[j];
		A[j]=A[jPlus1];
		A[jPlus1]=temp;
	}
	
	/**
	 * 
	 * @param A
	 * @param pass : 0 means no pass counter, for non-zero pass counter will be printed.
	 * @param msg
	 */
	public static void printArray(int[] A, int pass, String msg) {
		
		msg = ((pass > 0) ? ("Pass-"+ pass + " ") : "") + msg;
		
		System.out.println("\n\n"+ msg);
		
		for(int a : A) System.out.print(a + " ");
	}

	public static void printArray(int[] A, int from, int to) {
		
		System.out.println("\nArray from " + from + " to " + to);
		
		for(int i = from; i <= to; i++) System.out.print(A[i] + " ");
	}
	
	public static void printMsg(String msg) {
		System.out.println("\n\n"+msg);
	}
}
