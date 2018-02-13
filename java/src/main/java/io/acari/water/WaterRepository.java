package io.acari.water;

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
    long halfWay = liquidContainer.fetchTotalCapacity() / 2;
    long maximumFetchableWater = waterSupply.maximumFetchableWater();
    boolean halfOrMore = maximumFetchableWater >= halfWay;
    long tripsDivisor = halfOrMore ? halfWay : maximumFetchableWater;
    long trips = (long) Math.ceil(halfWay / (double) tripsDivisor);
    for (int i = 0; i < trips; i++) {
      long diffToHalf = halfWay - liquidContainer.fetchCurrentVolume();
      if (diffToHalf < maximumFetchableWater) {
        liquidContainer.storeWater(diffToHalf);
      } else {
        liquidContainer.storeWater(maximumFetchableWater);
      }
    }
    return liquidContainer;
  }
}
