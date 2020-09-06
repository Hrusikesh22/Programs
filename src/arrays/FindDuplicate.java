package arrays;

/**
 * T.C - O(n)
 * S.C - O(1)
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 */

class FindDuplicate  {
	
	public static void main(String[] args) 
	{ 
		FindDuplicate duplicate = new FindDuplicate(); 
		int arr[] = {1, 2, 3, 1, 3, 6, 6}; 
		int arr_size = arr.length; 
		
		duplicate.printRepeating(arr, arr_size); 
	} 
	
	//This won't work if array contains a number>Array_size
	
	void printRepeating(int arr[], int size) {
		
		System.out.println("The repeating elements are : "); 
	
		for (int i = 0; i < size; i++) 
		{ 
			if (arr[ Math.abs(arr[i])] >= 0) 
				arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
			else
				System.out.print(Math.abs(arr[i]) + " "); 
		}
		
		System.out.println();
		
		for(int i : arr) 
			System.out.print(i + " ");
	} 

} 

