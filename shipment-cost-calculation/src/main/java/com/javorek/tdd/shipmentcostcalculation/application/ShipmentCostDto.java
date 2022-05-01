package com.javorek.tdd.shipmentcostcalculation.application;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ShipmentCostDto {
    String shipmentId;
    BigDecimal asMoney;
}
