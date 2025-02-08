
import java.util.List;

interface AnimalQueries {

    List<Animal> getAnimalsByHeight(double height);

    List<Animal> getAnimalsThatCanMakeSound();

    List<Animal> getAnimalsOfType(Class<? extends Animal> type);
}
