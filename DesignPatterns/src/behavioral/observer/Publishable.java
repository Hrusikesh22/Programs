package behavioral.observer;

/*
 * This is the actual SUBJECT which will be Publish
 */
public interface Publishable 
{
    public void subscribe(Observer o);
    public void unSubscribe(Observer o);
    public void notifyAll(Message m);
}

