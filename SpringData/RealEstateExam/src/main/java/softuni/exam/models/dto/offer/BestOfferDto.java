package softuni.exam.models.dto.offer;

import java.math.BigDecimal;

public class BestOfferDto {
    private String firstName;
    private String lastName;
    private long offerId;
    private double area;
    private String townName;
    private BigDecimal price;

    public BestOfferDto(String firstName, String lastName, long offerId, double area, String townName, BigDecimal price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.offerId = offerId;
        this.area = area;
        this.townName = townName;
        this.price = price;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getOfferId() {
        return offerId;
    }

    public double getArea() {
        return area;
    }

    public String getTownName() {
        return townName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Agent %s %s with offer №%d:\n" +
                "\t-Apartment area: %.2f\n" +
                "\t--Town: %s\n" +
                "\t---Price: %.2f$",getFirstName(), getLastName(), getOfferId(), getArea(), getTownName(), getPrice());
    }
}
