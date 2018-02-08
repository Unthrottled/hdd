package io.acari.water;

public interface WaterSupply {

  /**
   * @param desiredAmount the amount of water to retrieve from
   *                      the water supply
   * @return the maximum amount of water that can be supplied each invocation
   * @throws IllegalArgumentException if given a number less than zero
   */
  long fetchWater(long desiredAmount);

  /**
   * @return the largest amount of water that can be returned from the water supply
   * per invocation.
   */
  long maximumFetchableWater();
}
