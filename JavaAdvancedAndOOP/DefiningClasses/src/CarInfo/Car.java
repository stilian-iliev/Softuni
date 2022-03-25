package CarInfo;

public class Car {
    private String make;
    private String model;
    private int hp;

    public Car(String make, String model, int hp) {
        this.make = make;
        this.model = model;
        this.hp = hp;
    }


    public String toString(){
        return String.format("The car is: %s %s - %d HP.",this.make,this.model,this.hp);
    }
}
