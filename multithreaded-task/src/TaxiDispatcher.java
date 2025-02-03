import java.util.concurrent.BlockingQueue;

public class TaxiDispatcher implements Dispatcher {
    private final BlockingQueue<TaxiDriver> availableTaxis;

    public TaxiDispatcher(BlockingQueue<TaxiDriver> availableTaxis) {
        this.availableTaxis = availableTaxis;
    }

    @Override
    public void placeOrder() {
        try {
            TaxiDriver taxi = availableTaxis.take();
            System.out.println("Dispatcher assigning an order to Taxi with ID: " + taxi.getId());
            new Thread(taxi).start();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
