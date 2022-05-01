package com.javorek.tdd.shipmentcostcalculation.infrastructure;

import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCost;
import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCostRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ShipmentCalculationInMemoryRepository implements ShipmentCostRepository {
    private Map<String, ShipmentCost> shipmentCostByShipmentId = new HashMap<>();

    @Override
    public ShipmentCost save(ShipmentCost shipmentCost) {
        return shipmentCostByShipmentId.put(shipmentCost.getShipmentId(), shipmentCost);
    }

    @Override
    public Optional<ShipmentCost> findOne(String shipmentId) {
        return shipmentCostByShipmentId.values().stream()
                .filter(it -> it.getShipmentId().equals(shipmentId))
                .findFirst();
    }
}
