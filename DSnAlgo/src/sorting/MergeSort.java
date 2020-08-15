package sorting;
/**
 * O(nlogn)
 * @since 01/08/2020
 */
public class MergeSort {

	public static void main(String[] s) {

		int[] A = {38, 27, 43, 3, 9, 82, 10};

		Utils.printArray(A, 0, "I/P for Merge Sort.........");

		divideAndConquer(A, 0, A.length-1);

		Utils.printArray(A, 0, "After Merge Sort.........");
	}

	static void divideAndConquer(int[] A, int start, int end) {

		if(A == null || A.length == 0 || start == end) 		//Base condition
			return;
		
		int mid = (start + end)/2;
		divideAndConquer(A, start, mid);
		divideAndConquer(A, mid+1, end);

		sortAndmerge(A, start, mid, mid+1, end);
	}

	static void sortAndmerge(int[] A, int start1, int end1, int start2, int end2) {

		//Utils.printArray(A, start1, end1);
		//Utils.printArray(A, start2, end2);

		int start1Copy = start1;							//To be used to copy from temp array to actual array.

		int totalLength = (end2 - start1)+1;				//With some example can get this formula easily.

		int[] tempArr = new int[totalLength];				//To store merged result.
		int tempArrInx = 0;

		while(start1 <= end1 && start2 <= end2) {
			if(A[start1] > A[start2]) {
				tempArr[tempArrInx++] = A[start2++]; 		// Both the array indices post assignment auto incremented.
			} else {										//Assuming original array with distinct elements. 
				tempArr[tempArrInx++] = A[start1++];
			}
		}

		while(start1 <= end1) {								//Copy remaining of list1 if list2 is completed 
			tempArr[tempArrInx++] = A[start1++];
		}

		while(start2 <= end2) {								//Copy remaining of list2 if list1 is completed
			tempArr[tempArrInx++] = A[start2++];
		}

		for(int i : tempArr) {								//Copy temp array to original array.
			A[start1Copy++] = i;
		}

		//Utils.printArray(A, 0, "After Merged....");
	}
}
