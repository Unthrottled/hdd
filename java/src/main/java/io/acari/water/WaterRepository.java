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
        long l1 = waterSupply.maximumFetchableWater();
        long l = l1 >= halfWay ? halfWay : l1;
        long trips =(long) Math.ceil(halfWay / (double) l);
        for (int i = 0; i < trips; i++) {
          long l2 = halfWay - liquidContainer.fetchCurrentVolume();
          if(l2 < l1){
            liquidContainer.storeWater(l2);
          } else {
            liquidContainer.storeWater(l1);
          }
        }
        return liquidContainer;
    }
}
