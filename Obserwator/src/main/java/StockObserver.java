public class StockObserver implements Observer {
    private double PKOPrice;
    private double CDPROJEKTPrice;
    private double PKNORLENPrice;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;

        this.observerID = ++observerIDTracker;

        System.out.println("New Observer " + this.observerID);

        stockGrabber.register(this);
    }

    public void update(double PKOPrice, double CDPROJEKTPrice, double PKNORLENPrice) {
        this.PKOPrice = PKOPrice;
        this.CDPROJEKTPrice = CDPROJEKTPrice;
        this.PKNORLENPrice = PKNORLENPrice;

        printThePrices();
    }

    public void printThePrices() {
        System.out.println("Observer: " + observerID + "\nPKO: " + PKOPrice + "\nCDPROJEKT: " + CDPROJEKTPrice + "\nPKNORLEN: " + PKNORLENPrice + "\n");
    }
}