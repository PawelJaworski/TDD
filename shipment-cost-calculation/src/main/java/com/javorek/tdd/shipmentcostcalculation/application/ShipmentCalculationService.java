package com.javorek.tdd.shipmentcostcalculation.application;

import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCost;
import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCostRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
public class ShipmentCalculationService {
    private final ShipmentCostRepository shipmentCostRepository;
    private final ShipmentCostMapper mapper;

    public void saveCalculation(ShipmentCalculationCmd shipmentCalculationCmd) {

        var shipmentCost = calculateShipmentCost(shipmentCalculationCmd);
        shipmentCostRepository.save(shipmentCost);
    }

    public ShipmentCost calculateShipmentCost(ShipmentCalculationCmd shipmentCalculationCmd) {
        var shipmentId = shipmentCalculationCmd.getShipmentId()
                .get();
        BigDecimal fuelCost = calculateFuelCost(shipmentCalculationCmd);
        return ShipmentCost.builder()
                .shipmentId(shipmentId)
                .fuelCost(fuelCost)
                .additionalCosts(shipmentCalculationCmd.getAdditionalCosts())
                .build();
    }

    private  BigDecimal calculateFuelCost(ShipmentCalculationCmd shipmentCalculationCmd) {
        return shipmentCalculationCmd.getFuelConsumptionByCar()
                .divide(new BigDecimal("100"))
                .multiply(shipmentCalculationCmd.getRouteLength())
                .multiply(shipmentCalculationCmd.getFuelPriceForOneLiter())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public ShipmentCostDto findByShipmentId(String shipmentId) {
        return shipmentCostRepository.findOne(shipmentId)
                .map(mapper::map)
                .orElseThrow();
    }
}
