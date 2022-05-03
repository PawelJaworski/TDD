package com.javorek.tdd.shipmentcostcalculation.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class AdditionalCost {
    String type;
    Money amount;
}
