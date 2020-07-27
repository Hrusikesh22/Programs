package collections;


import java.util.Collections;  
import java.util.Comparator;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.LinkedHashMap;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;  

public class SortHashMapByValue   
{  
	public static void main(String[] args)   
	{  
		//implementing HashMap  
		HashMap<Integer, String> hm = new HashMap<Integer, String>();  
		hm.put(6, "Tushar");  
		hm.put(12, "Ashu");  
		hm.put(5, "Zoya");  
		hm.put(78, "Yash");  
		hm.put(10, "Praveen");  
		hm.put(67, "Boby");  
		hm.put(1, "Ritesh");  
		
		System.out.println("Before Sorting:");  
		
		Set<Entry<Integer, String>> set = hm.entrySet();  
		
		Iterator<Entry<Integer, String>> iterator = set.iterator();  
		
		while(iterator.hasNext())   
		{  
			Map.Entry<Integer, String> map = (Map.Entry<Integer, String>)iterator.next();  
			System.out.println("Roll no:  "+map.getKey()+"     Name:   "+map.getValue());  
		}  
		
		Map<Integer, String> map = sortValues(hm);   
		
		System.out.println("\n");  
		System.out.println("After Sorting:");  
		
		Set<Entry<Integer, String>> set2 = map.entrySet();  
		
		Iterator<Entry<Integer, String>> iterator2 = set2.iterator();  
		while(iterator2.hasNext())   
		{  
			Map.Entry<Integer, String> me2 = (Map.Entry<Integer, String>)iterator2.next();  
			System.out.println("Roll no:  "+me2.getKey()+"     Name:   "+me2.getValue());  
		}  
	}  
	//method to sort values  
	private static HashMap<Integer, String> sortValues(HashMap<Integer, String> map)   
	{   
		List<Entry<Integer, String>> list = new LinkedList<Entry<Integer, String>>(map.entrySet());  
		//Custom Comparator  
		Collections.sort(list, new Comparator()   
		{  
			public int compare(Object o1, Object o2)   
			{  
				return ((Comparable) ((Map.Entry<Integer, String>) (o1)).getValue()).compareTo(((Map.Entry<Integer, String>) (o2)).getValue());  
			}  
		});  
		
		//copying the sorted list in HashMap to preserve the iteration order  
		HashMap<Integer, String> sortedHashMap = new LinkedHashMap<Integer, String>();  
		for (Iterator<Entry<Integer, String>> it = list.iterator(); it.hasNext();)   
		{  
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) it.next();  
			sortedHashMap.put(entry.getKey(), entry.getValue());  
		}   
		return sortedHashMap;  
	}  
} 