package thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass_SuperInstanceVarValueTest {
	public static void main(String[] str) {
		ExecutorService execService = Executors.newFixedThreadPool(2);
		execService.execute(new MyThread());
		execService.execute(new MyThread());
	}
}
