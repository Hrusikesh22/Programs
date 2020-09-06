package Utilities;

import java.util.Vector;

/*
 * https://dzone.com/articles/how-to-capture-java-heap-dumps-7-options
 * VM Arguments : -Xmx128m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=OOM.hprof
 * 
 * JVisualVM
 * Eclipse MAT (Memory Analyzer)
 * Your-kit
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
