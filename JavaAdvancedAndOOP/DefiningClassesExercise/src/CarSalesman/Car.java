package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, -1, null);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, null);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        String weightStr = String.valueOf(weight);
        if (weight == -1) {
            weightStr = "n/a";
        }
        String colorStr = color;
        if (color == null) {
            colorStr = "n/a";
        }
        String displacementStr = String.valueOf(engine.getDisplacement());
        if (engine.getDisplacement() == -1){
            displacementStr = "n/a";
        }
        String efficiencyStr = engine.getEfficiency();
        if (engine.getEfficiency() == null){
            efficiencyStr = "n/a";
        }

        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n"
                ,this.model,engine.getModel(),engine.getPower(),displacementStr,efficiencyStr, weightStr,colorStr );
    }
}
