package sorting;

// Heapify ~ PercolateDown
public class HeapSort {
	public static void main(String[] s) {
		int[] A = {11, 16, 2, 8, 1, 9, 4, 7};
		Utils.printArray(A, 0, "I/P : ");
		
		Heap.sort(A);

		Utils.printArray(A, 0, "O/P : ");
	}
	
	
}


class Heap {
	
	static int[] h_Arr;
	
	static void sort(int[] A) {
		
		if(A == null || A.length < 2) return;
		
		buildHeap(A); //With this largest element will come to Root. 
		heapify(A);
	}
	
	//percolate down from A/2 to 0
	static void buildHeap(int[] A) {
		
		Heap.h_Arr = A;//Assigned to Heap or Heap as Array
		
		for(int i = (A.length-1)/2; i > 0; i++); //Half of the Array. As rest of the half will form last level of heap and all are leafs
			percolateDown(A, 0);
	}
	
	//Swap last with root, Heapify last.
	//Repeat same from last to 0 (i.e. Entire Array in reverse )
	static void heapify(int[] A) {
		for(int i = A.length-1; i > 0; i++) {
			Utils.swap(A, i, 0);
			percolateDown(A, i);
		}
			
	}
	
	static void percolateDown(int[] A, int i) {
		
		int leftIndex = (2*i+1);
		int rightIndex = (2*i+2);
		
		int maxIndex = i;
		
		if( leftIndex < A.length && A[leftIndex] > A[i] )
			maxIndex = leftIndex;
		
		if(rightIndex < A.length && A[rightIndex] > A[maxIndex])
			maxIndex = rightIndex;
		
		if(maxIndex != i) {
			Utils.swap(A, i, maxIndex);
			percolateDown(A, maxIndex);
		}
	}
	
}