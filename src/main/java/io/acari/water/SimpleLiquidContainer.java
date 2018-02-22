package io.acari.water;

import java.util.Optional;

public class SimpleLiquidContainer implements LiquidContainer {
    private final long maxCapacity;
    private Water currentCapacity;

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
    public Water storeWater(Water volumeOfWater) {
        return null;
    }

    @Override
    public Water fetchCurrentVolume() {
        return currentCapacity;
    }
}
