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
        .orElseThrow(()->new IllegalArgumentException("Cannot create liquid instance with value " + amount));
    }

    private Optional<Long> sanitizeVolume(long amount) {
        return Optional.of(amount)
        .filter(aLong -> aLong > -1);
    }

    public long getAmount() {
        return amount;
    }
    public Liquid addLiquid(Liquid liquid){
        this.amount = getAmount() + liquid.getAmount();
        return this;
    }

    public Optional<? extends Liquid> reduceVolumeBy(long subtractor){
        return sanitizeVolume(subtractor)
                .flatMap(this::reduceAmount);
    }

    private Optional<? extends Liquid> reduceAmount(long volume){
        long amount = getAmount();
        this.amount = volume > amount ? 0 : amount - volume;
        return Optional.of(instanceFactory.apply(volume));
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
