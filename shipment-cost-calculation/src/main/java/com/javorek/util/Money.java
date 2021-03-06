package com.javorek.util;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Value
public class Money {
    public static final Money ZERO = new Money(BigDecimal.ZERO);
    private static int SCALE = 2;
    private static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    BigDecimal asBigDecimal;

    public static Money convert(String number) {
        return convert(new BigDecimal(number));
    }

    public static Money convert(BigDecimal number) {
        var scaled = number.setScale(SCALE, ROUNDING_MODE);
        return new Money(scaled);
    }

    public Money add(Money other) {
        return new Money(asBigDecimal.add(other.asBigDecimal));
    }

    public Money subtract(Money other) {
        return new Money(asBigDecimal.subtract(other.asBigDecimal));
    }
}
