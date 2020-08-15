package sorting;

/**
 * GeeksForGeeks video
 * Each iteration removes an element(let say Marker) from i/p and inserts into the correct position.
 * Left to marker are sorted, and to rights are un-sorted.
 * In each iteration, Marker will be placed at the correct position and then move marker to right by one position.
 * @since 01.08.2020
 *
 */
public class InsertionSort {
	
	public static void main(String[] s) {
		
		int[] A = {7,8,5,2,4,6,3};
		Utils.printArray(A, 0, "I/P:");
		
		for(int i = 1; i <= A.length-1; i++) {

			Utils.printArray(A, i, "(Marker-" + A[i] + ")");
			
			int marker = A[i];
			
			int j = i;
			while(j > 0 && A[j-1] > marker) {
				A[j] = A[j-1];
				--j; 	//Till previous greater check and decrement j
			}
			
			A[j]= marker;
			
			Utils.printArray(A, i, "After");
		}
	}
}

/*
 * In below approach of 2 for-loops, we are swapping every time, that is not required.
 * Rather keep marked value as temp and keep comparing, swap at the end of inner loop.
 * for(int i = 1; i <= A.length-1; i++) {
			for(int j = i; j > 0; j--) {
				if(A[j-1]>A[j]) {
					Utils.swap(A, j-1, j);
				}
			}
		}
 */

/*
 * Simple Implementation
 * Efficient (than Bubble and Selection though all are of O(n*n)) for small data.
 * Adaptive: If i/p list is pre-sorted (may not be completely) then insertions sort takes O(n+d), d=number of inversions.
 * Online: It can sort the list as it receives it.
 * 
 */
