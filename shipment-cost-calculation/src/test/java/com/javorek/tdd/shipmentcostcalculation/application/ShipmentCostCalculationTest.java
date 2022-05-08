package com.javorek.tdd.shipmentcostcalculation.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentCostCalculationTest {
    ShipmentCalculationService shipmentCalculationService;

    @BeforeEach
    void beforeEach() {
       shipmentCalculationService = new ShipmentCalculationService(new ShipmentCostMapperImpl());
    }
}
