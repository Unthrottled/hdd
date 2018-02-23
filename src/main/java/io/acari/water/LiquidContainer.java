package io.acari.water;

public interface LiquidContainer {
    /**
     * @return the total volume container, regardless of fill level.
     */
    long fetchTotalCapacity();

    /**
     * Fills the container with the desired amount of water.
     *
     * @param volumeOfWater desired amount of water to place in container, must be greater than zero
     * @return amount of water stored in container
     * @throws IllegalStateException if given number lower than zero.
     */
    Liquid storeWater(Liquid volumeOfWater);

    /**
     * @return The amount of liquid currently stored in the container.
     */
    Liquid fetchCurrentVolume();
}
