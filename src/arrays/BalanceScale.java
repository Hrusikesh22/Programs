package arrays;

/**
 * At max 2 elements can be picked to balance the scale.
 * Return answer (the element(s) picked) as string in ascending order, else return "not possible"
 * @since 05/09/2020
 *
 */
public class BalanceScale {

	public static void main(String[] args) {
		/*int[] weighingScale = {5, 9};
		int[] arr = {1, 2, 6, 7};*/
		
		String[] inputStrs = {"{5, 9}", "{1, 2, 6, 7}"};
		
		System.out.println("Result - " + findWeightToBalance(inputStrs));
	}

	private static String findWeightToBalance(String[] inputStrs) {
		
		String scaleLeftVal = inputStrs[0].split(",")[0].trim();
		String scaleRightVal = inputStrs[0].split(",")[1].trim();
		int scaleLeftWt = Integer.parseInt(scaleLeftVal.substring(1)+"");
		int scaleRightWt = Integer.parseInt(scaleRightVal.substring(0, scaleRightVal.length()-1)+"");
		int[] availableWts = getArrOfNumbers(inputStrs);
		
		System.out.println("scaleLeftWt - " + scaleLeftWt + ", scaleRightWt -" + scaleRightWt);
		System.out.print("Available Wts : ");
		for(int i : availableWts) System.out.print(i+ " ");
		System.out.print("\n");
		
		for(int i=0; i<availableWts.length; i++) {
			
			//Case-1 : Add single number from array to either of scale weight to balance
			int firstNo = availableWts[i];
			if(scaleLeftWt+firstNo == scaleRightWt || scaleRightWt+firstNo == scaleLeftWt)
				return firstNo+"";
			
			for(int j=i+1; j<availableWts.length; j++) {
				int secondNo = availableWts[j];
				//case-2 : Add both the numbers on either of scale weight to balance;
				int sumOf2Nos = firstNo+secondNo;
				if(scaleLeftWt+sumOf2Nos == scaleRightWt || scaleRightWt+sumOf2Nos == scaleLeftWt) {
					return firstNo>secondNo ? secondNo+","+firstNo : firstNo+","+secondNo; 
				} 
				else if(scaleLeftWt+firstNo == scaleRightWt+secondNo ||
						scaleLeftWt+secondNo == scaleRightWt+firstNo ) {
					return firstNo>secondNo ? secondNo+","+firstNo : firstNo+","+secondNo; 
				}
			}
			
		}
		return "not possible";
	}
	
	private static int[] getArrOfNumbers(String[] inputStrs) {
		String availableWts = inputStrs[1];
		String[] availableWtsStrArr = availableWts.replace("{", "").replace("}", "").split(",");
		
		int[] availableWtsIntArr = new int[availableWtsStrArr.length];
		
		for(int i=0; i<availableWtsStrArr.length; i++) {
			availableWtsIntArr[i] = Integer.parseInt(availableWtsStrArr[i].trim());
		}
		
		return availableWtsIntArr;
	}

}
