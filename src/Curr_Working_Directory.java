
public class Curr_Working_Directory {

	public static void main(String args[]) {
		
		String current = System.getProperty("user.dir");//Window, might not work on Linux
		
		//On linux export CONFIG_FILE_PATH=<file_direcotry> and use as below using getevn
		//System.getenv(Constants.CONFIG_FILE_PATH)
		
		System.out.println("Current working directory in Java : " + current);
	}
}


