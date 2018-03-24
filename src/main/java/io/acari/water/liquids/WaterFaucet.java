package io.acari.water.liquids;

public class WaterFaucet implements WaterSupply {
    @Override
    public Water fetchWater(long desiredAmount) {
        return new Water(desiredAmount);
    }
}
