package arrays;

import java.util.Arrays;

/**
 * @since 05/09/2020
 * Input: 1-n
 * 
 * Approach-1(Brute Force) : Sort array, iterate over till we find repeating and missing both. O(nlogn)+O(n) ~ O(nlogn) 
 * 
 * Approach-2 (In-place)
 * So find duplicate by putting -ve at the corresponding index approach.
 * Then use n(n+1)/2 after removing
 * 
 * Approach-3 (Extra Array)
 * Take an extra temp_array[n], add 0/1(or no. of repeatations) at the corresponding index for not-present/present.
 * Then scan  temp_array to collect missing and duplicate element. [Map can be used instead of array also]
 */

public class FindMissingFrom1ToN_1Missing_1Duplicate {
	public static void main(String[] str) {
		int[] inputArr = {1, 2, 5, 6, 3, 7,7};
		//missingAndDuplicate(inputArr, "Approach-1");
		missingAndDuplicate(inputArr, "Approach-2");
		//missingAndDuplicate(inputArr, "Approach-3");
	}

	static void missingAndDuplicate(int[] inputArr, String approach) {
		switch(approach) {
			case "Approach-1": approach1(inputArr); break;
			case "Approach-2": approach2(inputArr); break;
			case "Approach-3": approach3(inputArr); break;
		}
	}

	static void approach1(int[] inputArr) {
		int arrSize = inputArr.length;
		int expectedTotal =  arrSize*(arrSize+1)/2; //n(n+1)/2
		
		Arrays.sort(inputArr);
		
		int dupNo = -1; int actualSum = 0;
		for(int i=0; i<arrSize; i++) {
			if(dupNo == -1 && inputArr[i]==inputArr[i+1]) {
				dupNo = inputArr[i];
			}
			actualSum += inputArr[i];
		}
		
		System.out.println(" Missing No : " + (expectedTotal - (actualSum - dupNo)) + " Duplicate No : " + dupNo);
	}

	static void approach2(int[] inputArr) {
		
		int arrSize = inputArr.length;
		int expectedTotal =  arrSize*(arrSize+1)/2; //n(n+1)/2

		int dupNo=0;int actualSum = 0;
		for(int i=0; i<arrSize; i++) {
			int currNo = Math.abs(inputArr[i]);//IMP: Pick abs as we are corrupting original array adding -ve
			actualSum += currNo;
			
			if(inputArr[currNo-1] > 0)//not -ve
				inputArr[currNo-1] = -inputArr[currNo-1];
			else
				dupNo = currNo;
		}
		
		System.out.println(" Missing No : " + (expectedTotal - (actualSum - dupNo)) + " Duplicate No : " + dupNo);
	}

	static void approach3(int[] inputArr) {
		int arrSize = inputArr.length;
		int expectedTotal =  arrSize*(arrSize+1)/2; //n(n+1)/2
		int[] tempArr = new int[arrSize+1];
		
		int dupNo=0; int actualSum = 0;
		for(int i=0; i<arrSize; i++) {

			int currNo = inputArr[i];
			actualSum += currNo;
			
			if(tempArr[currNo]==0)
				tempArr[currNo] = 1;
			else
				dupNo = currNo;
		}
		System.out.println(" Missing No : " + (expectedTotal - (actualSum - dupNo)) + " Duplicate No : " + dupNo);
	}
}
