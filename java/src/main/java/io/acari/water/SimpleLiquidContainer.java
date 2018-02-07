package io.acari.water;

public class SimpleLiquidContainer implements LiquidContainer {

  public SimpleLiquidContainer(long maxCapacity) {

  }

  @Override
  public long fetchTotalCapacity() {
    return 0L;
  }

  @Override
  public long storeWater(long volumeOfWater) {
    return 0L;
  }

  @Override
  public long fetchCurrentVolume() {
    return 0L;
  }
}
