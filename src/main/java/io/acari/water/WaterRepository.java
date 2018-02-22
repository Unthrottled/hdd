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
    return liquidContainer;
  }
}
