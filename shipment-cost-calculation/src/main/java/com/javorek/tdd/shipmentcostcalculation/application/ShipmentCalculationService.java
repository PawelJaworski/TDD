package com.javorek.tdd.shipmentcostcalculation.application;

import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCost;
import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCostRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RequiredArgsConstructor
public class ShipmentCalculationService {
    private final ShipmentCostRepository shipmentCostRepository;
    private final ShipmentCostMapper mapper;

    public void saveCalculation(ShipmentCalculationCmd shipmentCalculationCmd) {
        var shipmentId = shipmentCalculationCmd.getShipmentId()
                .get();
        BigDecimal cost = calculateShipmentCost(shipmentCalculationCmd);
        var shipmentCost = new ShipmentCost(shipmentId, cost);
        shipmentCostRepository.save(shipmentCost);
    }

    public BigDecimal calculateShipmentCost(ShipmentCalculationCmd shipmentCalculationCmd) {
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
