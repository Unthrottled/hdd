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
        Optional<Liquid> optionalLiquid = fetchCurrentVolume();
        if (optionalLiquid.isPresent()) {
            Liquid currentLiquid = optionalLiquid.get();
            this.liquidStored = currentLiquid.addLiquid(pourCorrectAmount(liquid));
        } else if (liquid.getAmount() > maxCapacity) {
            this.liquidStored = liquid.reduceVolumeBy(maxCapacity).orElseThrow(()->new IllegalStateException("Should have been able to remove max capacity amount of liquid!"));
        } else {
            this.liquidStored = liquid.reduceVolumeBy(liquid.getAmount()).orElseThrow(() -> new IllegalStateException("Should have been able to reduce by current amount!"));
        }
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
