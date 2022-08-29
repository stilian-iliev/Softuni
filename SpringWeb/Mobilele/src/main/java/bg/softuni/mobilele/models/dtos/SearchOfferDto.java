package bg.softuni.mobilele.models.dtos;

public class SearchOfferDto {
    private String model;
    private Integer minPrice;
    private Integer maxPrice;

    public void setModel(String model) {
        this.model = model;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getModel() {
        return model;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }
}
