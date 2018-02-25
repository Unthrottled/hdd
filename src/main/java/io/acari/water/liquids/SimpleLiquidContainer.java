package io.acari.water.liquids;

import java.util.Optional;

public class SimpleLiquidContainer implements LiquidContainer {
    private final long maxCapacity;
    private Liquid currentCapacity;

    public SimpleLiquidContainer(long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public long fetchTotalCapacity() {
        return maxCapacity;
    }

    @Override
    public Liquid storeLiquid(Liquid liquid) {
        return null;
    }

    @Override
    public Optional<Liquid> fetchCurrentVolume() {
        return Optional.ofNullable(currentCapacity);
    }
}
