package io.acari.water;

import io.acari.water.liquids.Liquid;
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
        long goalAmount = liquidContainer.fetchTotalCapacity() / 2;
        Liquid currentVolume = liquidContainer.fetchCurrentVolume().isPresent() ?
                liquidContainer.fetchCurrentVolume()
                        .filter(liquid -> liquid.getAmount() <= goalAmount)
                        .orElseThrow(() -> new IllegalStateException("Container is too full!")) :
                waterSupply.fetchWater(0);

        liquidContainer.storeLiquid(waterSupply.fetchWater(goalAmount - currentVolume.getAmount()));
        return liquidContainer;
    }
}
