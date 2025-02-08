
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Zoo implements AnimalManagement, SupervisorAssignment, AnimalQueries {

    private final Map<String, Animal> animals = new HashMap<>();
    private final List<SupervisorChangeObserver> observers = new ArrayList<>();

    public Zoo() {
    }

    public Zoo(Collection<Animal> animalCollection) {
        for (Animal animal : animalCollection) {
            animals.put(animal.getAnimalId(), animal);
        }
    }

    @Override
    public void addAniaml(Animal animal) {
        animals.put(animal.getAnimalId(), animal);
    }

    @Override
    public Animal searchAnimalById(String id) {
        return animals.get(id);
    }

    @Override
    public boolean delelteAnimalById(String id) {
        return animals.remove(id) != null;
    }

    @Override
    public void assignSupervisorToAnimal(String animalId, Supervisor supervisor) {
        Animal animal = animals.get(animalId);
        if (animal != null) {
            Supervisor oldSupervisor = animal.getSupervisor();
            if (oldSupervisor == null || !oldSupervisor.equals(supervisor)) {
                animal.setSupervisor(supervisor);
                notifyObservers(animal, oldSupervisor, supervisor);
            } else {
                System.out.println("ERROR: you are trying to assign the same supervisor again to the same animal");
            }
        } else {
            System.out.println("ERROR: animal with ID " + animalId + " does not exist in our humble zoo");
        }

    }

    @Override
    public List<Animal> getAnimalsBySupervisorName(String name) {
        return animals.values().stream()
                .filter(a -> a.getSupervisor() != null && a.getSupervisor().getSupervisorName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> getAnimalsByHeight(double height) {
        return animals.values().stream().filter(a -> a.getAnimalHeight() > height).collect(Collectors.toList());
    }

    @Override
    public List<Animal> getAnimalsThatCanMakeSound() {
        return animals.values().stream().filter(Animal::canMakesound).collect(Collectors.toList());
    }

    @Override
    public List<Animal> getAnimalsOfType(Class<? extends Animal> type) {
        return animals.values().stream().filter(type::isInstance).collect(Collectors.toList());
    }

    @Override
    public List<Animal> getAnimalsBySupervisorId(String supervisorId) {
        return animals.values().stream()
                .filter(a -> a.getSupervisor() != null && a.getSupervisor().getSupervisorId().equals(supervisorId))
                .collect(Collectors.toList());
    }

    public void addObserver(SupervisorChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SupervisorChangeObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Animal animal, Supervisor oldSupervisor, Supervisor newSupervisor) {
        for (SupervisorChangeObserver observer : observers) {
            observer.onSupervisorChanged(animal, oldSupervisor, newSupervisor);
        }
    }

}
