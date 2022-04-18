package com.javorek.tdd.hownotto;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    int calculate(int first, String operation, int second) {
        return first + second;
    }
}
