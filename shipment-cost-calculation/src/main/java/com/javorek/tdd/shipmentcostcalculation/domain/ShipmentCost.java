package com.javorek.tdd.shipmentcostcalculation.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class ShipmentCost {
    private String shipmentId;
    private BigDecimal asMoney;
}
