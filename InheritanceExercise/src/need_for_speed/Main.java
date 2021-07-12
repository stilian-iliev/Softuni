package need_for_speed;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(10, 10);
        System.out.println(vehicle.getFuelConsumption());

        RaceMotorcycle raceMotorcycle = new RaceMotorcycle(10,10);
        System.out.println(raceMotorcycle.getFuelConsumption());
    }
}
