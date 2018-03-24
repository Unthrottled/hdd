package io.acari.water.liquids;

import java.util.Optional;

public class SimpleLiquidContainer implements LiquidContainer {
    private final long maxCapacity;
    private Liquid liquidStored = new Liquid(0);

    public SimpleLiquidContainer(long maxCapacity) {
        this.maxCapacity = Optional.of(maxCapacity)
                .filter(c -> c > -1)
                .orElseThrow(() -> new IllegalArgumentException("Cannot store liquid amounts less than zero!"));
    }

    @Override
    public long fetchTotalCapacity() {
        return maxCapacity;
    }

    @Override
    public Liquid storeLiquid(Liquid liquid) {
        return liquidStored.addLiquid(pourCorrectAmount(liquid));
    }

    private Liquid pourCorrectAmount(Liquid liquid) {
        long capacityLeft = maxCapacity - liquidStored.getAmount();
        boolean willStillBeEmpty = capacityLeft > liquid.getAmount();
        return willStillBeEmpty ?
                liquid :
                liquid.reduceVolumeBy(capacityLeft).orElseThrow(() -> new IllegalStateException("Should have gotten liquid!!"));
    }

    @Override
    public Optional<Liquid> fetchCurrentVolume() {
        return Optional.ofNullable(liquidStored);
    }
}
