import java.util.concurrent.BlockingQueue;


public class MultithreadedTaxiApp {
    public static void main(String[] args) {
        int numberOfTaxis = 3;
        BlockingQueue<TaxiDriver> availableTaxis = TaxiSystemInitializer.initializeTaxis(numberOfTaxis);

        TaxiDispatcher dispatcher = new TaxiDispatcher(availableTaxis);

        for(int i = 0; i < 5; i++) {
            new Thread(dispatcher::placeOrder).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
