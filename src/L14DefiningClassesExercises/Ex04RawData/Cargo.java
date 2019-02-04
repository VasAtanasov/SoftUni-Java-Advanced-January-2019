package L14DefiningClassesExercises.Ex04RawData;

public class Cargo {
    private String type;
    private int weight;

    public Cargo(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return this.type;
    }
}
