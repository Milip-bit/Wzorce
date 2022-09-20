public class GrabStocks {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setPKOPrice(23.72);
        stockGrabber.setCDPROJEKTPrice(89.29);
        stockGrabber.setPKNORLENPrice(56.24);

        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.setPKOPrice(23.72);
        stockGrabber.setCDPROJEKTPrice(89.29);
        stockGrabber.setPKNORLENPrice(56.24);

        Runnable getPKO = new GetTheStock(stockGrabber, 2, "PKO", 23.72);
        Runnable getCDPROJEKT = new GetTheStock(stockGrabber, 2, "CDPROJEKT", 89.29);
        Runnable getPKNORLEN = new GetTheStock(stockGrabber, 2, "PKNORLEN", 56.24);

        new Thread(getPKO).start();
        new Thread(getCDPROJEKT).start();
        new Thread(getPKNORLEN).start();
    }
}