package sorting;

/**
 * @since 01.08.2020
 * O(n*n)
 */
public class SelectionSort {
	
	static int[] A = {5,9,4,2,8,1};
	
	public static void main(String[] s) {

		for(int i = 0; i < A.length-1; i++) {//i is the counter
			
			int minIndex = i; 
			
			Utils.printArray(A, i+1, "before");
			
			for(int j = i; j < A.length; j++) {
				
				if(A[j] < A[minIndex]) {
					minIndex = j;
				}
			}
			
			Utils.swap(A, i, minIndex);
			
			Utils.printArray(A, i+1, "after (min="+ A[minIndex] +")");
		}
	}
	
	void logic() {
		/*
		 * counter = o //index
		 * SELECT MIN in A[counter - end]
		 * Swap(A[counter]<=>Min)
		 * ++counter
		 */
	}
	
	void usage() {
		/*
		 * Swap when min found i.e. When required. 
		 * So better than Bubble as swap is no frequent. 
		 */
	}
	
	
}
