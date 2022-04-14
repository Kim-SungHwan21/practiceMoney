package com.nhnacademy.project;

import java.math.BigDecimal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        Money m1 = MoneyService.won(BigDecimal.valueOf(15600));
        Money m2 = MoneyService.euro(BigDecimal.valueOf(102));
        Money m3 = MoneyService.dollar(BigDecimal.valueOf(100));

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            context.getBean("moneyService", MoneyService.class).exchange(m1);
            context.getBean("moneyService", MoneyService.class).exchange(m2);
            context.getBean("moneyService", MoneyService.class).exchange(m3);
        }
    }
}
