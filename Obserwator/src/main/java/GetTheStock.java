import java.text.DecimalFormat;
import java.lang.Math;

public class GetTheStock implements Runnable  {
    private final String stock;
    private double price;

    private final Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice) {
        this.stockGrabber = stockGrabber;

        stock = newStock;
        price = newPrice;
    }

    public void run() {
        for(int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {

            }

            double randNum = (Math.random() * (.06)) - .03;

            DecimalFormat df = new DecimalFormat("#.##");

            price = Math.round((price + randNum) * 1e2) / 1e2;

            if(stock == "PKO") ((StockGrabber) stockGrabber).setPKOPrice(price);
            if(stock == "CDPROJEKT") ((StockGrabber) stockGrabber).setCDPROJEKTPrice(price);
            if(stock == "PKNORLEN") ((StockGrabber) stockGrabber).setPKNORLENPrice(price);

            System.out.println(stock + ": " + df.format((price + randNum)) + " zmiana " + df.format(randNum));
            System.out.println("===========");
        }
    }
}