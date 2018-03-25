package io.acari.water.liquids;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class Liquid {
    private long amount;
    Function<Long, ? extends Liquid> instanceFactory = Liquid::new;

    /**
     * @param amount any number above -1
     * @throws IllegalArgumentException if given any number below zero
     */
    Liquid(long amount) {
        this.amount = sanitizeVolume(amount)
                .orElseThrow(() -> new IllegalArgumentException("Cannot create liquid instance with value " + amount));
    }

    private Optional<Long> sanitizeVolume(long amount) {
        return Optional.of(amount)
                .filter(aLong -> aLong > -1);
    }

    public long getAmount() {
        return amount;
    }

    /**
     * Moves the amount of liquid provided to this instance.
     *
     * @param liquid liquid to be drained and added to this instance.
     * @return this liquid instance with the added amount from the liquid provided.
     */
    public Liquid addLiquid(Liquid liquid) {
        this.amount = liquid.reduceVolumeBy(liquid.getAmount())
                .map(Liquid::getAmount)
                .orElse(0L) + getAmount();
        return this;
    }

    /**
     * Reduces the amount of liquid stored in this instance.
     * <p>
     * Will not return any liquid if asked more than the current amount
     * stored in instance.
     *
     * @param volumeToReduceBy the amount of liquid to remove from this instance
     * @return The amount of liquid ranging from 0 to current volume.
     */
    public Optional<? extends Liquid> reduceVolumeBy(long volumeToReduceBy) {
        return sanitizeVolume(volumeToReduceBy)
                .flatMap(this::reduceAmount);
    }

    private Optional<? extends Liquid> reduceAmount(long volume) {
        return sanitizeVolume(volume)
                .filter(goodVolume -> goodVolume <= getAmount())
                .map(reducingVolume -> {
                    this.amount = getAmount() - reducingVolume;
                    return reducingVolume;
                })
                .map(instanceFactory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Liquid)) return false;
        Liquid liquid = (Liquid) o;
        return amount == liquid.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
