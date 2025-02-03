import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class TaxiSystemInitializer {

    public static BlockingQueue<TaxiDriver> initializeTaxis(int numberOfTaxis) {
        BlockingQueue<TaxiDriver> availableTaxis = new LinkedBlockingQueue<>();

        IntStream.rangeClosed(1, numberOfTaxis).forEach(id -> 
        {
            TaxiDriver taxi = new TaxiDriver(id, availableTaxis);
            availableTaxis.add(taxi);
            System.out.println("Taxi with ID: " + id + " has be initialized");
        });
        return availableTaxis;
    }
}
