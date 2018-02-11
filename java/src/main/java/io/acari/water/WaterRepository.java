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
        long l = l1;
        long trips = (long) Math.ceil(halfWay / (double) l);
        for (int i = 0; i < trips; i++) {

        }
        return liquidContainer;
    }
}
