package sorting;
/**
 * @since 01.08.2020
 */
public class BubbleSort {

	static int[] A = {5,9,4,2,8,1};

	public static void main(String[] s) {
		int pass = 0;
		
		for(int i = 0; i <= A.length-1; i++) {

			Utils.printArray(A, ++pass, "before");
			
			for(int j = 0; j < A.length-i-1; j++) {
				if(A[j]> A[j+1]) {
					Utils.swap(A, j, j+1);
				}
			}
			
			Utils.printArray(A, pass, "before");
		}
	}

	/*
	 * Swap Consecutive if A[i]>A[i+1] to bring small to left
	 * In each pass exclude Right most (as it will have larger number at the pass end) and repeat again from 0 - (rightmost-1)
	 * Reference: GeeksForGeeks YT 
	 * 
	 * NK : Improvement using "isSwapped" flag check in outer loop. 
	 * For a pass if there is no swap terminate there, as it is likely sorted already.
	 */
}
