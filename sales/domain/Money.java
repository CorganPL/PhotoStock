package domain;

import java.math.BigDecimal;

public class Money {
    BigDecimal value;
    String currency;

    Money add(Money m) {
        return new Money(value.add(m.value), currency);
    }

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }
}
