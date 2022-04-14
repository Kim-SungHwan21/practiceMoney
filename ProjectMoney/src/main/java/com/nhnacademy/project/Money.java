package com.nhnacademy.project;


import static com.nhnacademy.project.Currency.DOLLAR;
import static com.nhnacademy.project.Currency.EURO;
import static com.nhnacademy.project.Currency.WON;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;


public class Money {
    BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (amount.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new IllegalArgumentException("Invalid amount: " + amount);
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money other) {
        checkCurrency(other, "Not matched currency. add this currency: ");
        return new Money(this.amount.add(other.amount), this.currency);
    }

    public BigDecimal getAmount() {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    public boolean equals(Object obj) {
        return true;
    }


    public Currency getCurrency() {
        return this.currency;
    }

    public Money substract(Money other) {
        checkCurrency(other, "Not matched currency. this currency: ");
        if (this.amount.compareTo(other.amount) < 0) {
        throw new IllegalArgumentException("other money greater than this");
        }
        return new Money(this.amount.subtract(other.amount), this.currency);
    }

    private void checkCurrency(Money other, String x) {
        if (!this.currency.equals(other.currency)) {
            throw new InvalidCurrencyException(
                    x + this.currency + System.lineSeparator() +
                            "other ccurrency: " + other.currency);
        }
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}




