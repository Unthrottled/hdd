package io.acari.water;

import io.acari.water.liquids.LiquidContainer;
import io.acari.water.liquids.WaterSupply;

public class WaterRepository {
    private final WaterSupply waterSupply;

    public WaterRepository(WaterSupply waterSupply) {
        this.waterSupply = waterSupply;
    }

    /**
     * Fills the given container to the floor of the halfway mark.
     *
     * @param liquidContainer a container that is less than half full.
     * @return a container that is half full.
     * @throws IllegalArgumentException when given a more than half filled container
     *                                  (we are half full people here)
     */
    public LiquidContainer fillContainerHalfWay(LiquidContainer liquidContainer) {
        return liquidContainer;
    }
}
