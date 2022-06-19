package bookshop_exercise.entity;

import java.math.BigDecimal;

public interface BookSummary {
    String getTitle();
    EditionType getEditionType();
    AgeRestriction getAgeRestriction();
    BigDecimal getPrice();
}
