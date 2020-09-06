package arrays;

import java.util.Arrays;

/**
 * Here input array starting from 0. If it starts from 1, need to modify program accordingly.
 * @since 05/09/2020
 */

public class FindMissingFrom1ToN_1Missing {
	public static void main(String[] str) {
		int[] inputArr = {1, 2, 4, 6, 3, 7, 0};
		missingNumber(inputArr);
	}
	
	public static int missingNumber(int[] nums) {
        
        int arrSize = nums.length;
        int expectedTotal = arrSize*(arrSize+1)/2; //n(n+1)/2

        System.out.print("Input : [ ");
        
        for(int i : nums){
            System.out.print(i + " ");
            expectedTotal -= i;
        }
        
        System.out.print("]\nResult : " + expectedTotal);
        
        return expectedTotal;
    }
}
