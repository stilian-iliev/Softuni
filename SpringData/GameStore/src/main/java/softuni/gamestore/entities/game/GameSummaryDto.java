package softuni.gamestore.entities.game;

import java.math.BigDecimal;

public class GameSummaryDto {
    private String title;
    private BigDecimal price;

    public GameSummaryDto() {}

    public GameSummaryDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", getTitle(), getPrice());
    }
}
