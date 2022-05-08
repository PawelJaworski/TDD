package com.javorek.tdd.shipmentcostcalculation.application;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class TestCases {
    String SHIPMENT_ID = "WAWBIA/1";
    BigDecimal FUEL_CONSUMPTION_BY_CAR = new BigDecimal(7);
    BigDecimal SHIPMENT_ROUTE_LENGTH = new BigDecimal(200);
    BigDecimal FUEL_PRICE_FOR_ONE_LITER = new BigDecimal(6.8);
    BigDecimal FUEL_PRICE_FOR_SHIPMENT_ROUTE = new BigDecimal("95.20");
    BigDecimal SHIPMENT_COST = new BigDecimal("116.70");
    String HIGHWAY = "highway";
    BigDecimal HIGHWAY_COST = new BigDecimal("21.50");
}
