package com.javorek.tdd.shipmentcostcalculation.application;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShipmentCostDto {
    private String shipmentId;
}
