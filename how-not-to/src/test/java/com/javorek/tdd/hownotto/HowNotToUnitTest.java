package com.javorek.tdd.hownotto;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class HowNotToUnitTest {
    CalculationValidator validator;
    CalculationService calculationService;

    @BeforeEach
    void beforeAll() {
        validator = mock(CalculationValidator.class);
        calculationService = new CalculationService(validator);
    }

    @Test
    @SneakyThrows
    void validate() {
        var wrong = new CalculationCmd(5, "additamentum", -1);
        calculationService.calculate(wrong);
        verify(validator, times(1)).validate(5, -1);
    }
}
