package com.javorek.tdd.hownotto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder(builderClassName = "Builder")
public class CalculationCmd {
    private int first;
    private String operation;
    private int second;

    public static class Builder {

        public Builder plus(int second) {
            operation = "additamentum";
            this.second = second;

            return this;
        }

        public Builder minus(int second) {
            operation = "detractio";
            this.second = second;

            return this;
        }

        public CalculationCmd build() {
            return new CalculationCmd(first, operation, second);
        }
    }
}
