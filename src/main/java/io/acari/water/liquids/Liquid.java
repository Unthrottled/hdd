package io.acari.water.liquids;

import java.util.Objects;
import java.util.Optional;

public class Liquid {
    private final long amount;

    /**
     * @param amount any number above -1
     * @throws IllegalArgumentException if given any number below zero
     */
    Liquid(long amount) {
        this.amount = Optional.of(amount)
        .filter(aLong -> aLong > -1)
        .orElseThrow(()->new IllegalArgumentException("Cannot create liquid instance with value " + amount));
    }

    public long getAmount() {
        return amount;
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
