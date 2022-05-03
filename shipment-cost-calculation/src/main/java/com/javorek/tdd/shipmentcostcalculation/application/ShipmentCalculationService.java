package com.javorek.tdd.shipmentcostcalculation.application;

import com.javorek.tdd.shipmentcostcalculation.domain.AdditionalCost;
import com.javorek.tdd.shipmentcostcalculation.domain.Money;
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

    public ShipmentCost calculateShipmentCost(ShipmentCalculationCmd cmd) {
        var shipmentId = cmd.getShipmentId()
                .get();
        BigDecimal fuelCost = calculateFuelCost(cmd);
        return ShipmentCost.builder()
                .shipmentId(shipmentId)
                .fuelCost(Money.convert(fuelCost))
                .additionalCost(
                        new AdditionalCost(cmd.getAdditionalCostType(), Money.convert(cmd.getAdditionalCostAmount())))
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
