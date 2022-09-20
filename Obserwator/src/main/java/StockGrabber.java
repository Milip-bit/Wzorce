import java.util.ArrayList;

public class StockGrabber implements Subject {

    private ArrayList<Observer> observers;
    private double PKOPrice;
    private double CDPROJEKTPrice;
    private double PKNORLENPrice;

    public StockGrabber() {
        observers = new ArrayList<Observer>();
    }

    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);

        System.out.println("Observer " + (observerIndex + 1) + " deleted");

        observers.remove(observerIndex);
    }

    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(PKOPrice, CDPROJEKTPrice, PKNORLENPrice);
        }
    }

    public void setPKOPrice(double newPKOPrice) {
        this.PKOPrice = newPKOPrice;

        notifyObserver();
    }

    public void setCDPROJEKTPrice(double newCDPROJEKTPrice) {
        this.CDPROJEKTPrice = newCDPROJEKTPrice;

        notifyObserver();
    }

    public void setPKNORLENPrice(double newPKNORLENPrice) {
        this.PKNORLENPrice = newPKNORLENPrice;

        notifyObserver();
    }
}