package car_shop_extend;

public class Audi extends CarImpl implements Rentable {
    private Integer minDays;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String country, Integer minDays, Double pricePerDay) {
        super(model, color, horsePower, country);
        this.minDays = minDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minDays;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("%s%nMinimum rental period of %d days. Price per day %f", super.toString(), minDays, pricePerDay);
    }
}
