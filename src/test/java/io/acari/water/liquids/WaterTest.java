package io.acari.water.liquids;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaterTest {

    @Test
    public void getAmountShouldThrowIllegalArgumentExceptionWhenGivenNegativeNumber() {
        try{
            new Water(-1);
            fail();
        } catch (IllegalArgumentException ignored){}
    }

    @Test
    public void getAmountShouldReturnConstructedValueWhenValid() {
        long input = 1L;
        long expectedResult = 1L;
        Water testGuy = new Water(input);
        long actualResult = testGuy.getAmount();
        assertEquals(expectedResult, actualResult);
    }

}