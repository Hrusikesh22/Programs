package sorting;

/*
 * O(nlogn)
 * @since 02/08/2020
 * Merge Sort vs Quick sort (Advantage/Disadvantage).
 * When to use what (GFG or any other place)
 */
public class QuickSort {
	
	public static void main(String[] s) {
		int[] A = {11, 16, 2, 8, 1, 9, 4, 7};
		Utils.printArray(A, 0, "I/P : ");
		
		partitionAndSort(A, 0, A.length-1);
	}
	
	static int pass = 0;
	
	static void partitionAndSort(int[] A, int start, int end) {
		
		Utils.printMsg("Pass-"+ ++pass+" :: start="+start+", end="+end);
		
		int pivot = end; 						//Last Element
		int curr = start, i = start;
		
		if( !(start<end) ) 						//IMP :: When called with only element in list/array
			return;
		
		while(curr < pivot) {
			
			if(A[curr] > A[pivot]) 
				curr++;
			else {
				Utils.swap(A, curr++, i++); 	//Swap and POST increment both
			}
		}
		Utils.swap(A, i, pivot);
		
		Utils.printArray(A, pass, "(Pivot="+pivot+", i="+i+")");
		
		partitionAndSort(A, start, i-1);
		partitionAndSort(A, i+1, end);
	}
}
