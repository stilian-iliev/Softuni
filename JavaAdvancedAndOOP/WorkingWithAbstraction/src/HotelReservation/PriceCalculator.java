package HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int days, Season season, String discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        switch (discount){
            case "VIP":
                this.discount = Discount.VIP;
                break;
            case "SecondVisit":
                this.discount = Discount.SECOND_VISIT;
                break;
            case "None":
                this.discount = Discount.NONE;
                break;
        }
    }


    public double calculate(){
        return ((pricePerDay * season.getMultiplier()) * days) * (1 - discount.getDiscount());
    }
}
