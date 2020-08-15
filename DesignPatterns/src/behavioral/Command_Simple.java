package behavioral;

/*
 * Client talks to invoker and pass the command object, Each command object has reference to it’s receiver
 * Example:
 * 1> Form Submission and processing in Spring MVC. Form is mapped to the object (here TV), then the respective command processes.
 * 2> Runnable interface (java.lang.Runnable)
 */
public class Command_Simple {
	
	public static void main(String[] s) {
		
		TV tv = new TV();
		
		RemoteController remote = new RemoteController(new TVOnCommand(tv));
		remote.press();
		
		remote = new RemoteController(new VolumeUpCommand(tv));
		remote.press();
		
		remote = new RemoteController(new VolumeDownCommand(tv));
		remote.press();

		remote = new RemoteController(new TVOffCommand(tv));
		remote.press();
	}
}

class RemoteController {

	ICommand command;
	
	public RemoteController(ICommand command) {//Command can be initialized via setter also.
		this.command = command;
	}
	
	public void press() { command.execute(); }
}

interface ICommand {
	public void execute();
}

class TVOnCommand implements ICommand {
	
	TV tv;
	
	TVOnCommand(TV tv){ this.tv = tv; }
	
	@Override
	public void execute() { tv.on(); }
}

class TVOffCommand implements ICommand {
	
	TV tv;
	
	TVOffCommand(TV tv){ this.tv = tv; }
	
	@Override
	public void execute() { tv.off(); }
}

class VolumeUpCommand implements ICommand{
	
	TV tv;
	
	VolumeUpCommand(TV tv){ this.tv = tv; }
	
	@Override
	public void execute() { tv.voulumeUp(); }
}

class VolumeDownCommand implements ICommand{
	
	TV tv;
	
	VolumeDownCommand(TV tv){ this.tv = tv; }
	
	@Override
	public void execute() { tv.voulumeDown(); }
}


class TV {
	public void on() {System.out.println("TV is On");}
	public void off() {System.out.println("TV is Off now");}
	public void voulumeUp() {System.out.println("TV volume has brough up");}
	public void voulumeDown() {System.out.println("TV volume has brough down");}
	
}
