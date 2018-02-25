package io.acari.water.liquids;

import org.junit.Test;

import static org.junit.Assert.*;

public class LiquidTest {

    @Test
    public void getAmountShouldThrowIllegalArgumentExceptionWhenGivenNegativeNumber() {
        try{
            new Liquid(-1);
            fail();
        } catch (IllegalArgumentException ignored){}
    }

    @Test
    public void getAmountShouldReturnConstructedValueWhenValid() {
        long input = 1L;
        long expectedResult = 1L;
        Liquid testGuy = new Liquid(input);
        long actualResult = testGuy.getAmount();
        assertEquals(expectedResult, actualResult);
    }
}