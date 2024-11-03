
public class Supervisor {

    private final String idSuperVisor;
    private final String supervisorName;
    private static int counter = 0;

    public Supervisor(String name) {
        this.idSuperVisor = "HR-" + getSupervisorNewId();
        this.supervisorName = name;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public String getSupervisorId() {
        return idSuperVisor;
    }

    public static int getSupervisorNewId() {
        counter++;
        return counter;
    }
}
