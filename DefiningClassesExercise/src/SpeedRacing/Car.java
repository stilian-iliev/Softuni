package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumption;
    private int distance;

    public Car(String model, int fuelAmount, double fuelConsumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
    }

    public boolean drive(int travelDistance) {
        if (travelDistance * fuelConsumption <= fuelAmount) {
            fuelAmount -= travelDistance * fuelConsumption;
            distance += travelDistance;
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distance);
    }
}
