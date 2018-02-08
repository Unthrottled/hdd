package io.acari.water;

import java.util.Optional;

public class SimpleLiquidContainer implements LiquidContainer {
  private final long maxCapacity;
  private long currentCapacity;

  public SimpleLiquidContainer(long maxCapacity) {
    this.maxCapacity = Optional.of(maxCapacity)
        .filter(c -> c > -1)
        .orElseThrow(() -> new IllegalArgumentException("Cannot store negatives!"));
  }

  @Override
  public long fetchTotalCapacity() {
    return maxCapacity;
  }

  @Override
  public long storeWater(long volumeOfWater) {
    long input = Optional.of(volumeOfWater)
        .filter(v -> v > -1)
        .orElseThrow(() -> new IllegalArgumentException("Cannot remove water!"));
    long diff = maxCapacity - currentCapacity;
    return diff >= input ? (currentCapacity += input) :
        (currentCapacity = maxCapacity);
  }

  @Override
  public long fetchCurrentVolume() {
    return currentCapacity;
  }
}
