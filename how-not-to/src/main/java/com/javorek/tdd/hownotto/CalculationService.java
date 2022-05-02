package com.javorek.tdd.hownotto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculationService {
    private static final String ERR_RESULT_IS_LOWER_THAN_0 = "You cannot subtract greater number from smaller one";
    private final CalculationValidator validator;

    public int calculate(CalculationCmd cmd) {
        int first = cmd.getFirst();
        String operation = cmd.getOperation();
        int second = cmd.getSecond();
        validator.validate(first, second);
        final int result;
        switch (operation) {
            case "additamentum":
                result = first + second;
                break;
            case "detractio":
                result = first - second;
                break;
            default:
                throw new IllegalStateException("Unsupported operation: " + operation);
        }

        if (result < 0){
            throw new ValidationException(ERR_RESULT_IS_LOWER_THAN_0);
        }

        return result;
    }
}
