package io.acari.water;

public interface WaterSupply {

    /**
     * @param desiredAmount the amount of water to retrieve from
     *                      the water supply
     * @return the requested amount of water that can be supplied each invocation
     * @throws IllegalArgumentException if given a number less than zero
     */
    long fetchWater(long desiredAmount);

}
