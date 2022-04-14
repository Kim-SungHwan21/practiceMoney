package com.nhnacademy.project;

import static com.nhnacademy.project.Currency.DOLLAR;
import static com.nhnacademy.project.Currency.EURO;
import static com.nhnacademy.project.Currency.WON;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyService {

    public BigDecimal exchange(Money money) {

        //Currency currency = null;
        if(money.getCurrency() == WON) {
            BigDecimal currencyRate = BigDecimal.valueOf(0.001);
            money.setCurrency(DOLLAR);
            money.amount = money.amount.multiply(currencyRate).setScale(2, RoundingMode.HALF_UP);
            System.out.println(money.amount);
            return money.amount;
        }
        if(money.getCurrency() == DOLLAR) {
            BigDecimal currencyRate = BigDecimal.valueOf(1000);
            money.setCurrency(WON);
            money.amount = money.amount.multiply(currencyRate).setScale(2, RoundingMode.HALF_UP);
            System.out.println(money.amount);
            return money.amount;
        }
        if(money.getCurrency() == EURO) {
            BigDecimal currencyRate = BigDecimal.valueOf(2000);
            money.setCurrency(WON);
            money.amount = money.amount.multiply(currencyRate).setScale(2,RoundingMode.HALF_UP);
            System.out.println(money.amount);
            return money.amount;
        }
        return money.amount;
    }

    public static Money dollar(BigDecimal amount) {
        return new Money(amount, DOLLAR);
    }

    public static Money euro(BigDecimal amount) {
        return new Money(amount, EURO);
    }

    public static Money won(BigDecimal amount) {
        return new Money(amount,WON);
    }

}
