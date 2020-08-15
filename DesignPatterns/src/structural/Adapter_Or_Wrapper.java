package structural;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * ADAPTER / WRAPPER / TRANSLATOR
 */
public class Adapter_Or_Wrapper {

	public static void main(String[] s) throws IOException {
		//Examples
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Writer writer = new OutputStreamWriter(new FileOutputStream("c:\\data\\output.txt"));
		//java.util.Arrays#asList()
	}

}

/*
 * Client --uses/calls--> TARGET( ADAPTER( ADAPTEE ) );
 * 
 * http://www.blackwasp.co.uk/Adapter.aspx#:~:text=The%20adapter%20pattern%20is%20a,translator%20between%20the%20two%20types.
 * 
 * pattern that is used to allow two incompatible types to communicate. Where one class relies upon a specific interface 
 * that is not implemented by another class, the adapter acts as a translator between the two types.
 * 
 * adapter acts as a TRANSLATOR
 * 
 * Also below has good java api reference of this pattern
 * 
 * https://howtodoinjava.com/design-patterns/structural/adapter-design-pattern-in-java/
 * 
 */