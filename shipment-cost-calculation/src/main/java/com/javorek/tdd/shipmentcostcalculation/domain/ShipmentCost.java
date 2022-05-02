package com.javorek.tdd.shipmentcostcalculation.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ShipmentCost {
    private String shipmentId;
    private BigDecimal fuelCost;
    private Map<String, BigDecimal> additionalCosts;
    public BigDecimal getAsMoney() {
        return additionalCosts.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .add(fuelCost);
    }
}
