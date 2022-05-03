package com.javorek.tdd.shipmentcostcalculation.application;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Value
@Builder
public class ShipmentCalculationCmd {
    @Builder.Default
    Optional<String> shipmentId = Optional.empty();
    BigDecimal routeLength;
    BigDecimal fuelPriceForOneLiter;
    BigDecimal fuelConsumptionByCar;
    String additionalCostType;
    @Builder.Default
    BigDecimal additionalCostAmount = BigDecimal.ZERO;
}
