package PIzzaCalories;

import java.util.Locale;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType.toLowerCase()){
            case "meat":
            case "veggies":
            case "cheese":
            case "sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight >50) throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",toppingType));
        this.weight = weight;
    }

    public double calculateCalories(){
        double modifier = ToppingsModifiers.valueOf(toppingType.toUpperCase(Locale.ROOT)).getModifier();
        return (2 * weight) * modifier;
    }
}
