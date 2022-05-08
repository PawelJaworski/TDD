package com.javorek.util;

import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCost;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public abstract class AbstractInMemoryRepository<ID, E> {
    private Map<ID, E> shipmentCostByShipmentId = new HashMap<>();

    public E save(E entity) {
        return shipmentCostByShipmentId.put(getId().apply(entity), entity);
    }

    public Optional<E> findOne(ID shipmentId) {
        return shipmentCostByShipmentId.values().stream()
                .filter(it -> getId().apply(it).equals(shipmentId))
                .findFirst();
    }

    protected abstract Function<E, ID> getId();
}
