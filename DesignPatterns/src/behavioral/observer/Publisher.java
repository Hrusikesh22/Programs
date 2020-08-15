package behavioral.observer;

import java.util.ArrayList;
import java.util.List;
/*
 * Concrete SUBJECT/PUBLISHABLE
 */
public class Publisher implements Publishable {
    
	//List of subscriber
    private List<Observer> observers = new ArrayList<>();
 
    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }
 
    @Override
    public void unSubscribe(Observer o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyAll(Message m) {
        for(Observer o : observers) {
            o.update(m);
        }
    }
}
