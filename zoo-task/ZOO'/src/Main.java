
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // create Animals:
        Animal cat1 = new Cat(10.5);
        Animal dog1 = new Dog(5.3);
        Animal cat2 = new Cat(7.1);
        Animal dog2 = new Dog(8.4);
        Animal fish = new Fish(2.3);
        Animal horse = new Horse(3.2);
        Animal Hippo = new Hippo(6.2);

        Supervisor supervisor1 = new Supervisor("Jalal");
        Supervisor supervisor2 = new Supervisor("Weshi");
        Supervisor supervisor3 = new Supervisor("Tim");

        // create zoo with animals:
        List<Animal> animals = new ArrayList<>();
        animals.add(horse);
        animals.add(cat1);
        animals.add(cat2);
        animals.add(fish);
        animals.add(dog1);
        animals.add(dog2);
        Zoo zoo = new Zoo(animals);

        SupervisorChangeLogger changeLogger = new SupervisorChangeLogger();
        zoo.addObserver(changeLogger);

        // add animal to the zoo using add method:
        zoo.addAniaml(Hippo);

        // get all animals cats from the zoo:
        List<Animal> cats = zoo.getAnimalsOfType(Cat.class);
        for (Animal cat : cats) {
            System.out.println("the animals with type cat have an id = " + cat.getAnimalId());
        }

        // animals that can make sounds
        List<Animal> animalsWithSound = zoo.getAnimalsThatCanMakeSound();
        System.out.println("number of animals that can make a sound = " + animalsWithSound.size());

        // assign supervisor to animals:
        zoo.assignSupervisorToAnimal(cat1.getAnimalId(), supervisor1);
        zoo.assignSupervisorToAnimal(dog1.getAnimalId(), supervisor1);
        zoo.assignSupervisorToAnimal(cat2.getAnimalId(), supervisor1);
        zoo.assignSupervisorToAnimal(dog2.getAnimalId(), supervisor2);
        zoo.assignSupervisorToAnimal(fish.getAnimalId(), supervisor2);
        zoo.assignSupervisorToAnimal(horse.getAnimalId(), supervisor1);
        zoo.assignSupervisorToAnimal(Hippo.getAnimalId(), supervisor3);

        // get animals with hieght more than 6:
        List<Animal> animalsWithHeight = zoo.getAnimalsByHeight(6);
        System.out.println("the number of animals with height more than 6 is " + animalsWithHeight.size());
        System.err.println("list of animals with height more than 6:");
        for (Animal animal : animalsWithHeight) {
            System.out.println("id = " + animal.getAnimalId() + " height = " + animal.getAnimalHeight());
        }

        // get animals with a supervisor name:
        List<Animal> animalsWithSupervisorName = zoo.getAnimalsBySupervisorName(supervisor1.getSupervisorName());
        System.out.println("name : " + supervisor1.getSupervisorName() + " , id : " + supervisor1.getSupervisorId());
        System.out.println(supervisor1.getSupervisorName() + " is a supervisor for those animals:");
        for (Animal animal : animalsWithSupervisorName) {
            System.out.println("id = " + animal.getAnimalId() + " height = " + animal.getAnimalHeight());
        }

        // get animal by supervisor id:
        List<Animal> animalsWithSupervisorId = zoo.getAnimalsBySupervisorId(supervisor2.getSupervisorId());
        System.out.println("name : " + supervisor2.getSupervisorName() + " , id : " + supervisor2.getSupervisorId());
        System.out.println(supervisor2.getSupervisorName() + " is a supervisor for those animals:");
        for (Animal animal : animalsWithSupervisorId) {
            System.out.println("id = " + animal.getAnimalId() + " height = " + animal.getAnimalHeight());
        }

        // search an animal using an id:
        Animal animalById = zoo.searchAnimalById(dog2.getAnimalId());
        System.out.println("animal with id: " + animalById.getAnimalId() + " with height: " + animalById.getAnimalHeight());

        // remove an animal from the zoo:
        zoo.delelteAnimalById(cat2.getAnimalId());
        System.out.println("search for the animal id after deleting:");
        System.out.println(zoo.searchAnimalById(cat2.getAnimalId()) + " !!animal has been deleteds if the id is null!!");

        // assign a supervisor for a deleted animal in the zoo:
        zoo.assignSupervisorToAnimal(cat2.getAnimalId(), supervisor3);

        // add another supervisor to an animal with a supervisor:
        zoo.assignSupervisorToAnimal(dog2.getAnimalId(), supervisor3);

        // assign the same supervisor to the same animal:
        zoo.assignSupervisorToAnimal(dog2.getAnimalId(), supervisor3);
    }

}
