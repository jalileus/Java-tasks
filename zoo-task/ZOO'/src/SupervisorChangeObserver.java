
interface SupervisorChangeObserver {

    void onSupervisorChanged(Animal animal, Supervisor oldSupervisor, Supervisor newSupervisor);
}

class SupervisorChangeLogger implements SupervisorChangeObserver {

    @Override
    public void onSupervisorChanged(Animal animal, Supervisor oldSupervisor, Supervisor newSupervisor) {
        String logEntry = "Animal with ID: " + animal.getAnimalId()
                + " changed from supervisor " + (oldSupervisor != null ? oldSupervisor.getSupervisorName() : "none")
                + " to supervisor " + newSupervisor.getSupervisorName();
        System.out.println(logEntry);
    }
}
