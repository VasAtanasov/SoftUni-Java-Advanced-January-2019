package L14DefiningClassesExercises.Ex04RawData;

public class Tier {
    private int age;
    private double pressure;

    public Tier(int age, double pressure) {
        this.age = age;
        this.pressure = pressure;
    }

    public double getPressure() {
        return this.pressure;
    }
}
