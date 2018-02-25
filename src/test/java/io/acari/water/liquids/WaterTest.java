package io.acari.water.liquids;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaterTest {

    @Test
    public void getAmountShouldThrowIllegalArgumentExceptionWhenGivenNegativeNumber() {
        try {
            new Water(-1);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void getAmountShouldReturnConstructedValueWhenValid() {
        long input = 1L;
        long expectedResult = 1L;
        Water testGuy = new Water(input);
        long actualResult = testGuy.getAmount();
        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void equalsShouldReturnFalseWhenNull() {
        assertFalse(new Water(0).equals(null));
    }


    @Test
    public void equalsShouldReturnFalseWhenLiquid() {
        assertFalse(new Water(0).equals(new Liquid(0)));
    }

    @Test
    public void equalsShouldReturnTrueWhenSameAmount() {
        assertTrue(new Water(0).equals(new Water(0)));
    }

    @Test
    public void equalsShouldReturnTrueWhenSameAmountPolymorphisim() {
        Liquid liquid = new Water(0);
        assertTrue(new Water(0).equals(liquid));
    }

    @Test
    public void equalsShouldReturnTrueWhenSameObject() {
        Water liquid = new Water(0);
        assertTrue(liquid.equals(liquid));
    }

}