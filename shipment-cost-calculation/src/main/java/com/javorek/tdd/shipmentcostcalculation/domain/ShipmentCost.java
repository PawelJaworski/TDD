package com.javorek.tdd.shipmentcostcalculation.domain;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
public class ShipmentCost {
    private String shipmentId;
}
