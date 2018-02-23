package io.acari.water.liquids;

public class Liquid {
    private final long amount;

    /**
     * @param amount any number above -1
     * @throws IllegalArgumentException if given any number below zero
     */
    Liquid(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
