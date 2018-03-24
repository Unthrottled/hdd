package io.acari.water.liquids;

public class Water extends Liquid {

    public Water(long amount) {
        super(amount);
        instanceFactory = Water::new;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Water && super.equals(o);
    }
}
