import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vehicleInput = sc.nextLine().split(" ");
        List<Vehicle> vehicleList = new ArrayList<>();
        int carHp = 0;
        int carCount = 0;
        int truckHp=0;
        int truckCount = 0;
        while (!vehicleInput[0].equals("End")){
            Vehicle vehicle = new Vehicle(vehicleInput[0],vehicleInput[1],vehicleInput[2],Integer.parseInt(vehicleInput[3]));
            vehicleList.add(vehicle);
            if (vehicleInput[0].equals("car")){
                carCount++;
                carHp+=vehicle.getHorsepower();
            } else {
                truckCount++;
                truckHp+=vehicle.getHorsepower();
            }
            vehicleInput = sc.nextLine().split(" ");
        }
        String modelInput = sc.nextLine();
        while (!modelInput.equals("Close the Catalogue")){
            for (Vehicle vehicle : vehicleList) {
                if (modelInput.equals(vehicle.getModel())){
                    System.out.print(vehicle.toString());
                }
            }
            modelInput = sc.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n",1.0*carHp/carCount);
        System.out.printf("Trucks have average horsepower of: %.2f.%n",1.0*truckHp/truckCount);
    }
}
class Vehicle{
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public Vehicle(String type, String model, String color, int horsepower){
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }
    @Override
    public String toString(){
        //str.substring(0, 1).toUpperCase() + str.substring(1)
        return String.format("Type: %s %nModel: %s %nColor: %s %nHorsepower: %d%n",type.substring(0,1).toUpperCase()+type.substring(1),model,color,horsepower);
    }
}