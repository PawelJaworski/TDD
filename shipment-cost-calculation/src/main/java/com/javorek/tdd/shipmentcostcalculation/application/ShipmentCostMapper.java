package com.javorek.tdd.shipmentcostcalculation.application;

import com.javorek.tdd.shipmentcostcalculation.domain.ShipmentCost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipmentCostMapper {
    ShipmentCostDto map(ShipmentCost shipmentCost);
}
