
import java.util.List;

interface SupervisorAssignment {

    void assignSupervisorToAnimal(String animalId, Supervisor supervisor);

    List<Animal> getAnimalsBySupervisorId(String supervisorId);

    List<Animal> getAnimalsBySupervisorName(String name);
}
