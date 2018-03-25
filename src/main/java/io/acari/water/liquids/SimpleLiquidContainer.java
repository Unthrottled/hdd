package io.acari.water.liquids;

import java.util.Optional;

public class SimpleLiquidContainer implements LiquidContainer {
    private final long maxCapacity;
    private Liquid liquidStored;

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
        Liquid currentLiquid = fetchCurrentVolume()
                .orElse(new Liquid(0L));
        this.liquidStored = currentLiquid.addLiquid(pourCorrectAmount(liquid));
        return liquidStored;
    }

    private Liquid pourCorrectAmount(Liquid liquid) {
        long capacityLeft = maxCapacity - fetchCurrentVolume()
                .map(Liquid::getAmount)
                .orElse(0L);
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
