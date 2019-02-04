package L14DefiningClassesExercises.Ex03SpeedRacing;

import java.text.DecimalFormat;

public class Car {
    private static final DecimalFormat df = new DecimalFormat("0.##");

    private String model;
    private double fuel;
    private double consumptionPerKm;
    private double distance;

    public Car(String model, double fuel, double consumptionPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.consumptionPerKm = consumptionPerKm;
        this.distance = 0.0;
    }

    public boolean drive(double distance) {
        double fuelConsumption = distance * this.consumptionPerKm;
        if (fuelConsumption > this.fuel) {
            return false;
        } else {
            this.distance += distance;
            this.fuel -= fuelConsumption;
            return true;
        }
    }


    public String getModel() {
        return this.model;
    }

    public double getFuel() {
        return this.fuel;
    }

    public String getDistance() {
        return df.format(this.distance);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s", this.getModel(), this.getFuel(), this.getDistance());
    }
}
