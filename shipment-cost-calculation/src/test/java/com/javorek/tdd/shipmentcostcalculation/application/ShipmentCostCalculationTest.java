package com.javorek.tdd.shipmentcostcalculation.application;

import com.javorek.tdd.shipmentcostcalculation.domain.AdditionalCost;
import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCostRepository;
import com.javorek.tdd.shipmentcostcalculation.infrastructure.ShipmentCalculationInMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentCostCalculationTest {
    ShipmentCalculationService shipmentCalculationService;

    @BeforeEach
    void beforeEach() {
        ShipmentCostRepository shipmentCostRepository = new ShipmentCalculationInMemoryRepository();
        ShipmentCostMapper mapper = new ShipmentCostMapperImpl();
        shipmentCalculationService = new ShipmentCalculationService(shipmentCostRepository, mapper);
    }

    @Test
    void shouldCalculateFuelCost() {
        // when
        var shipmentCalculationCmd = ShipmentCalculationCmd.builder()
                .shipmentId(Optional.of(TestCases.SHIPMENT_ID))
                .fuelConsumptionByCar(TestCases.FUEL_CONSUMPTION_BY_CAR)
                .routeLength(TestCases.BIA_WAW_ROUTE_LENGTH)
                .fuelPriceForOneLiter(TestCases.FUEL_PRICE_FOR_ONE_LITER)
                .build();
        var shipmentCost = shipmentCalculationService.calculateShipmentCost(shipmentCalculationCmd);
        // then
        assertEquals(TestCases.FUEL_PRICE_FOR_BIA_WAW_ROUTE, shipmentCost.getFuelCost());
    }

    @Test
    void shouldSaveCalculationAndRetrieveItLater() {
        // when
        var shipmentCalculationCmd = ShipmentCalculationCmd.builder()
                .shipmentId(Optional.of(TestCases.SHIPMENT_ID))
                .fuelConsumptionByCar(TestCases.FUEL_CONSUMPTION_BY_CAR)
                .routeLength(TestCases.BIA_WAW_ROUTE_LENGTH)
                .fuelPriceForOneLiter(TestCases.FUEL_PRICE_FOR_ONE_LITER)
                .build();
        shipmentCalculationService.saveCalculation(shipmentCalculationCmd);
        // then
        var found = shipmentCalculationService.findByShipmentId(TestCases.SHIPMENT_ID);
        assertEquals(TestCases.SHIPMENT_ID, found.getShipmentId());
    }

    @Test
    void shouldAddAdditionalCostNotRelatedToFuelCost() {
        // when
        var shipmentCalculationCmd = ShipmentCalculationCmd.builder()
                .shipmentId(Optional.of(TestCases.SHIPMENT_ID))
                .fuelConsumptionByCar(TestCases.FUEL_CONSUMPTION_BY_CAR)
                .routeLength(TestCases.BIA_WAW_ROUTE_LENGTH)
                .fuelPriceForOneLiter(TestCases.FUEL_PRICE_FOR_ONE_LITER)
                .additionalCostType(TestCases.HIGHWAY)
                .additionalCostAmount(TestCases.HIGHWAY_COST)
                .build();
        shipmentCalculationService.saveCalculation(shipmentCalculationCmd);
        // then
        var found = shipmentCalculationService.findByShipmentId(TestCases.SHIPMENT_ID);
        assertEquals(TestCases.SHIPMENT_ID, found.getShipmentId());
        assertEquals(TestCases.SHIPMENT_COST_FOR_BIA_WAR_ROUTE, found.getAsMoney());
    }
}
