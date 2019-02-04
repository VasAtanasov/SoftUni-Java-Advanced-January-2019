package L14DefiningClassesExercises.Ex04RawData;

import java.util.Arrays;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tier[] tiers;

    public Car(String[] parameters) {
        this.setModel(parameters[0]);
        this.setEngine(parameters);
        this.setCargo(parameters);
        this.setTiers(parameters);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(String[] parameters) {
        int speed = Integer.parseInt(parameters[1]);
        int power = Integer.parseInt(parameters[2]);
        this.engine = new Engine(speed, power);
    }

    public void setCargo(String[] parameters) {
        int weight = Integer.parseInt(parameters[3]);
        String type = parameters[4];
        this.cargo = new Cargo(type, weight);
    }

    public void setTiers(String[] parameters) {
        this.tiers = new Tier[4];
        for (int i = 5, j = 0; i < parameters.length; i += 2, j++) {
            double pressure = Double.parseDouble(parameters[i]);
            int age = Integer.parseInt(parameters[i + 1]);
            this.tiers[j] = new Tier(age, pressure);
        }
    }

    public boolean isValidTierPressure() {
        return Arrays.stream(this.tiers).anyMatch(tier -> tier.getPressure() < 1);
    }

    public boolean isValidEnginePower() {
        return this.engine.getPower() > 250;
    }

    public String getCargoType() {
        return this.cargo.getType();
    }

    @Override
    public String toString() {
        return this.model;
    }
}
