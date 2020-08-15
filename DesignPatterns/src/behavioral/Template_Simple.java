package behavioral;

/**
 * @since 04/08/20
 * Common behavior among sub-classes should be part of single/common class and avoid duplication.
 */
public class Template_Simple {
	
	public static void main(String[] args) {
		
		Game game = new Soccer();
		game.play();
		
		game = new Cricket();
		game.play();
	}
}

interface Game {
	void initialize();
	void start();
	void end();
	
	default void play() {//Common part 
		initialize(); start(); end();
	}
}

class Soccer implements Game {

	@Override
	public void initialize() { System.out.println("Soccer :: Initialized"); }
	@Override
	public void start() { System.out.println("Soccer :: Start"); }
	@Override
	public void end() { System.out.println("Soccer :: End"); }
}


class Cricket implements Game {

	@Override
	public void initialize() { System.out.println("Cricket :: Initialized"); }
	@Override
	public void start() { System.out.println("Cricket :: Start"); }
	@Override
	public void end() { System.out.println("Cricket :: End"); }
}