package com.javorek.tdd.hownotto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculationController {
    private final CalculationService service;

    @PostMapping
    int calculate(@RequestBody CalculationCmd cmd) {
        return service.calculate(cmd);
    }
}
