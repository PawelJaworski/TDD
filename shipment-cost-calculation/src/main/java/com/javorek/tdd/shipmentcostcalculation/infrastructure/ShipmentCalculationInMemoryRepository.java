package com.javorek.tdd.shipmentcostcalculation.infrastructure;

import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCost;
import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCostRepository;
import com.javorek.util.AbstractInMemoryRepository;

import java.util.function.Function;

public class ShipmentCalculationInMemoryRepository extends AbstractInMemoryRepository<String, ShipmentCost>
        implements ShipmentCostRepository {

    @Override
    protected Function<ShipmentCost, String> getId() {
        return shipmentCost -> shipmentCost.getShipmentId();
    }
}
