package io.acari.water;

import io.acari.water.liquids.LiquidContainer;
import io.acari.water.liquids.WaterSupply;

public class WaterRepository {
    private final WaterSupply waterSupply;

    public WaterRepository(WaterSupply waterSupply) {
        this.waterSupply = waterSupply;
    }

    /**
     * @param liquidContainer
     * @return
     */
    public LiquidContainer fillContainerHalfWay(LiquidContainer liquidContainer) {
        return liquidContainer;
    }
}
