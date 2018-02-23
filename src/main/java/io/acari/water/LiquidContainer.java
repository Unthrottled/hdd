package io.acari.water;

import io.acari.water.liquids.Liquid;

import java.util.Optional;

public interface LiquidContainer {
    /**
     * @return the total volume container, regardless of fill level.
     */
    long fetchTotalCapacity();

    /**
     * Fills the container with the desired amount of water.
     *
     * @param liquid desired amount of water to place in container, must be greater than zero
     * @return amount of liquid stored in container
     */
    Liquid storeLiquid(Liquid liquid);

    /**
     * @return The amount of liquid currently stored in the container.
     */
    Optional<Liquid> fetchCurrentVolume();
}
