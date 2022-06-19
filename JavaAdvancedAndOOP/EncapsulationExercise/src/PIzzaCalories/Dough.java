package PIzzaCalories;

import java.util.Locale;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        switch (flourType.toLowerCase()){
            case "white":
            case "wholegrain":
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique.toLowerCase()){
            case "crispy":
            case "chewy":
            case "homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories(){
        double firstModifier = DoughModifiers.valueOf(flourType.toUpperCase(Locale.ROOT)).getModifier();
        double secondModifier =  DoughModifiers.valueOf(bakingTechnique.toUpperCase(Locale.ROOT)).getModifier();
        return (2 * weight) * firstModifier * secondModifier;
    }
}
