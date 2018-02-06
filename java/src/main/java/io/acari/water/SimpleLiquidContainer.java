package io.acari.water;

public class SimpleLiquidContainer implements LiquidContainer {
  private final long maxCapacity;
  private long currentCapacity;

  public SimpleLiquidContainer(long maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  @Override
  public long fetchTotalCapacity() {
    return maxCapacity;
  }

  @Override
  public long storeWater(long volumeOfWater) {
    long diff = maxCapacity - currentCapacity;
    return diff >= volumeOfWater ? (currentCapacity += volumeOfWater) :
        (currentCapacity = maxCapacity);
  }

  @Override
  public long fetchCurrentVolume() {
    return currentCapacity;
  }
}
