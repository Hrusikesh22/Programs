package Utilities;

import java.util.Vector;

/*
 * JVisualVM
 * Eclipse MAT (Memory Analyzer)
 * Yourkit
 */

public class OOMTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	  {
	    @SuppressWarnings("rawtypes")
		Vector v = new Vector();
	    while (true)
	    {
	      byte b[] = new byte[1048576];
	      v.add(b);
	      Runtime rt = Runtime.getRuntime();
	      System.out.println( "free memory: " + rt.freeMemory() );
	    }
	  }
}
