package _05_bills_db;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Month;
import java.time.Year;

@Entity
public class CreditCard extends BillingDetail{
    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "expiration_month", nullable = false)
    private Month expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private Year expirationYear;
}
