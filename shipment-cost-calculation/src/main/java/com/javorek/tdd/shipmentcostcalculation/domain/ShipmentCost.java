package com.javorek.tdd.shipmentcostcalculation.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ShipmentCost {
    private String shipmentId;
    private Money fuelCost;
    private AdditionalCost additionalCost;
    public BigDecimal getAsMoney() {
        return Optional.ofNullable(additionalCost)
                .map(AdditionalCost::getAmount)
                .orElse(Money.ZERO)
                .add(fuelCost)
                .getAsBigDecimal();
    }
}
