
abstract class Animal {

    private final String id;
    private Supervisor supervisor;
    private final double height;
    private static int counter = 0;

    public Animal(double height) {
        this.id = "A-" + getAnimalNewId();
        this.height = height;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public final String getAnimalId() {
        return id;
    }

    public double getAnimalHeight() {
        return height;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public static int getAnimalNewId() {
        ++counter;
        return counter;
    }

    public abstract boolean canMakesound();
}
