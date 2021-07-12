package ferrari;

public class Ferrari implements Car {
    private String driverName;
    private String model;

    public Ferrari(String driverName){
        this.driverName = driverName;
        model = "488-Spider";
    }

    public String getModel() {
        return model;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }
}
