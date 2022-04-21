package com.javorek.tdd.hownotto;

import org.springframework.stereotype.Component;

@Component
public class CalculationValidator {
    private static String ERR_GREATER_THAN_9 = "Cannot calculate integers > 9";
    private static String ERR_LESS_OR_EQUAL_0 = "Cannot calculate integers <= 0";

    public void validate(int first, int second) {
        if (first > 9) {
            throw new ValidationException(ERR_GREATER_THAN_9);
        }
        if (second > 9) {
            throw new ValidationException(ERR_GREATER_THAN_9);
        }
        if (first <= 0) {
            throw new ValidationException(ERR_LESS_OR_EQUAL_0);
        }
        if (second <= 0) {
            throw new ValidationException(ERR_LESS_OR_EQUAL_0);
        }
    }
}
