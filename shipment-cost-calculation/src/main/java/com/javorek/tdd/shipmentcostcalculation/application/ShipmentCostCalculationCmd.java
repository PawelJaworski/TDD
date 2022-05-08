package com.javorek.tdd.shipmentcostcalculation.application;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ShipmentCostCalculationCmd {
    BigDecimal fuelPriceForOneLiter;
    BigDecimal routeLength;
    BigDecimal fuelConsumption;
}
