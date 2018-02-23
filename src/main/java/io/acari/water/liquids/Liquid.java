package io.acari.water.liquids;

public class Liquid {
    private final long amount;

    Liquid(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
