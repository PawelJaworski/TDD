package com.javorek.tdd.shipmentcostcalculation.domain;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Value
public class Money {
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
}
