package behavioral.observer;

public class SubscriberOne implements Observer 
{
    @Override
    public void update(Message m) {
        System.out.println("SubscriberOne Message :: " + m.getMessage());
    }
}
