package behavioral;

/**
 * https://howtodoinjava.com/design-patterns/behavioral/state-design-pattern/
 * @since 05/08/2020
 * Class behaves differently on Changing STATE of it's one of the property (class/type)
 * Example : Threads (changing thread state)
 * Advantage:
 * Can easily add new states and new behaviors in the application without impacting other components.
 * It also helps in reducing complexity by reducing the use of 'if-else' statements or switch/case conditional logic.
 */
public class State {
	
	public static void main(String[] s) {
		DeliveryContext context = new DeliveryContext("ABCXX11");
		context.update();
		context.update();
		context.update();
	}
}

/*
 * Class which will behave differently on Changing state of it's one field which is the state holding class/type i.e. PackageState(s) 
 */
class DeliveryContext {
	
	private String packageId;
	private PackageState packageState = Acknowledge.getInstance(); //Started with 1st state.
	
	public DeliveryContext(String packageId) { this.packageId = packageId; }
	
	public void update() {
		packageState.updateState(this);
	}
	
	public String getPackageId() { return packageId; }
	public void setPackageState(PackageState packageState) { this.packageState = packageState; }
}

interface PackageState {
	public void updateState(DeliveryContext ctx);
}

class Acknowledge implements PackageState {

	private static Acknowledge ack = new Acknowledge(); //SINGLETON : for betterment
	
	public static Acknowledge getInstance() {return ack;}

	@Override
	public void updateState(DeliveryContext ctx) {
		System.out.println("Order '" + ctx.getPackageId() + "' Acknowledged !!!");
		ctx.setPackageState(OutForDelivery.getInstance());
	}
}

class OutForDelivery implements PackageState {

	private static OutForDelivery ofd = new OutForDelivery(); //SINGLETON : for betterment
	
	public static OutForDelivery getInstance() {return ofd;}
	
	@Override
	public void updateState(DeliveryContext ctx) {
		System.out.println("Your Order '" + ctx.getPackageId() + "' Is Out For Delivery !!!");
		/*if(true)//Ready_For_Delivery*/			
			ctx.setPackageState(Delivered.getInstance());
		/*else if(true)//Problem in Delivery, restart from any other state.
			ctx.setPackageState(Triag.getInstance());*/
	}
}

class Delivered implements PackageState {

	private static Delivered delvrd = new Delivered(); //SINGLETON : for betterment
	
	public static Delivered getInstance() {return delvrd;}
	
	@Override
	public void updateState(DeliveryContext ctx) {
		System.out.println("Congratulations, Your Order '" + ctx.getPackageId() + "' Delivered !!!");
		//No further state update as reached final state.
	}
}

