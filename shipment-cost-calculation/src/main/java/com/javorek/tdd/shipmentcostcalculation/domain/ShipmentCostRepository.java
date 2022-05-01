package com.javorek.tdd.shipmentcostcalculation.domain;

import java.util.Optional;

public interface ShipmentCostRepository {
    ShipmentCost save(ShipmentCost shipmentCost);
    Optional<ShipmentCost> findOne(String shipmentId);
}
