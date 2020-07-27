package collections.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WildcardDemo 
{ 
    public static void main(String[] args) 
    { 
          
        List<Integer> list1 = Arrays.asList(4,5,6,7); 
          
        System.out.println("Total sum is:"+sum(list1)); 
  
        List<Double> list2 = Arrays.asList(4.1,5.1,6.1); 
          
        System.out.print("Total sum is:"+sum(list2)); 
    } 
  
    /**
     * ? extends Number - UPPER BOUNDED
     * @param list
     * @return
     */
    private static double sum(List<? extends Number> list)  
    { 
    	list.add(11);
        double sum=0.0; 
        
        for (Number i: list) { 
            sum+=i.doubleValue(); 
        } 
  
        return sum; 
    } 
} 
