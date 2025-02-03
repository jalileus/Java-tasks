import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class TaxiDriver implements Taxi, Runnable {
    private final int id;
    private final BlockingQueue<TaxiDriver> availableTaxis;

    public TaxiDriver(int id, BlockingQueue<TaxiDriver> availableTaxis) {
        this.id = id;
        this.availableTaxis = availableTaxis;
    }

    @Override
    public void performtask() {
        System.out.println("Taxi with ID: " + id + " is fulfilling an order...");
        try {
            Thread.sleep(new Random().nextInt(3000) + 1000);
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Taxi with ID: " + id + " has completed the order!");

        try {
            availableTaxis.put(this);
            System.out.println("Taxi with ID: " + id + " is now available");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        performtask();
    }

    public int getId() {
        return id;
    }

}
