package strings;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * SubSequence : Sub_Str/Any_Sequence/Same_Order_Of_Chars
 * @since 02/09/20
 *
 */
public class AllSubSequences {
	public static void main(String[] str) {
		String input = "ABCD";
		//System.out.println(input.substring(1, 4));
		subSequences(input);
		System.out.println(resultSet.size() + "\n" + resultSet);
	}

	//********** INCOMPLETE ***********
	
	private static Set<String> resultSet = new LinkedHashSet<String>();
	
	private static void subSequences(String inputStr) {
		
		if(inputStr == null || inputStr.isEmpty())
			return ;
		
		int strLen = inputStr.length();
		for(int i = 0; i < strLen; i++ ) {
			resultSet.add(String.valueOf(inputStr.charAt(i)));
			int count = 1;
			for(int j = i+1; j < strLen; j++ ) {
				
				String strConcatInJ = ""+inputStr.charAt(i) + inputStr.charAt(j);
				resultSet.add(strConcatInJ);
				
				String subStrItoJ = inputStr.substring(i, j+1);
				resultSet.add(subStrItoJ); 

				String subStrIandJtoEnd = inputStr.charAt(i) + inputStr.substring(j);
				resultSet.add(subStrIandJtoEnd); 
			}
		}
	}
}
