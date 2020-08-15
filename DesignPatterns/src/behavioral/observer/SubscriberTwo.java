package behavioral.observer;

public class SubscriberTwo implements Observer {
	 
	@Override
	    public void update(Message message) {
	        System.out.println("SubscriberTwo Message :: " + message.getMessage());
	    }
}
