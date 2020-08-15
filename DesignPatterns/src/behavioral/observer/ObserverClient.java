package behavioral.observer;

public class ObserverClient {
	
	public static void main(String[] args) 
    {
        SubscriberOne s1 = new SubscriberOne();
        SubscriberTwo s2 = new SubscriberTwo();
         
        Publisher p = new Publisher();
         
        p.subscribe(s1);
        p.subscribe(s2);
         
        p.notifyAll(new Message("Subject Notified 1"));   //s1 and s2 will receive the update
         
        p.unSubscribe(s1);
         
        p.notifyAll(new Message("Second Message")); //s2 removed. so s1 will receive the update only.
    }
}
