package com.javorek.tdd.hownotto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculationController {
    private final CalculationService service;

    @GetMapping
    int calculate(int first, String operation, int second) {
        return service.calculate(first, operation, second);
    }
}
