package com.javorek.tdd.howto;

import com.javorek.tdd.hownotto.CalculationService;
import com.javorek.tdd.hownotto.CalculationValidator;
import com.javorek.tdd.hownotto.ValidationException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MathCalculationTest {
    CalculationValidator validator = new CalculationValidator();
    CalculationService calculationService = new CalculationService(validator);

    @Test
    @Order(1)
    void should_Add2Integers() {
        var result = calculationService.calculate(3, "+", 5);
        Assertions.assertEquals(result, 8);
    }

    @Test
    @Order(2)
    void should_Subtract2Integers() {
        var result = calculationService.calculate(5, "-", 3);
        Assertions.assertEquals(result, 2);
    }

    @Test
    @Order(3)
    void should_RaiseError_When_IntegersGreaterThan9() {
        Exception firstGreaterThan9 = assertThrows(ValidationException.class, () -> {
            calculationService.calculate(10, "+", 1);
        });
        Assertions.assertEquals(firstGreaterThan9.getMessage(), "Cannot calculate integers > 9");

        Exception secondGreaterThan9 = assertThrows(ValidationException.class, () -> {
            calculationService.calculate(1, "+", 10);
        });
        Assertions.assertEquals(secondGreaterThan9.getMessage(), "Cannot calculate integers > 9");
    }

    @Test
    @Order(3)
    void should_RaiseError_When_IntegersEqualOrLessThan0() {
        Exception firstIsZero = assertThrows(ValidationException.class, () -> {
            calculationService.calculate(0, "+", 1);
        });
        Assertions.assertEquals(firstIsZero.getMessage(), "Cannot calculate integers <= 0");

        Exception secondGreaterThan9 = assertThrows(ValidationException.class, () -> {
            calculationService.calculate(1, "+", 0);
        });
        Assertions.assertEquals(secondGreaterThan9.getMessage(), "Cannot calculate integers <= 0");
    }

    @Test
    @Order(4)
    void should_RaiseError_When_ResultLowerThan0() {
        Exception exception = assertThrows(ValidationException.class, () -> {
            calculationService.calculate(1, "-", 2);
        });
        Assertions.assertEquals(exception.getMessage(), "You cannot subtract greater number from smaller one");
    }
}
