package io.acari.water.liquids;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    public void addAmountShouldReturnWaterWhenAddedWater(){
        Water input = new Water(9000L);
        Water testWater = new Water(1L);
        Water result = testWater.addLiquid(input);
        assertThat(result != testWater).isFalse();
        assertThat(result.getAmount()).isEqualTo(9001L);
        assertThat(testWater.getAmount()).isEqualTo(9001L);
        assertThat(input.getAmount()).isEqualTo(0L);
    }

    @Test
    public void addAmountShouldReturnSameAmount(){
        Water testWater = new Water(1L);
        Water result = testWater.addLiquid(testWater);
        assertThat(result.getAmount()).isEqualTo(1L);
        assertThat(testWater.getAmount()).isEqualTo(1L);
    }

    @Test
    public void addAmountShouldReturnLiquidWhenAddedWaterAsLiquid(){
        Liquid input = new Water(9000L);
        Water testWater = new Water(1L);
        Liquid result = testWater.addLiquid(input);
        assertThat(result != testWater).isFalse();
        assertThat(result instanceof Water).isTrue();
        assertThat(result.getAmount()).isEqualTo(9001);
        assertThat(testWater.getAmount()).isEqualTo(9001L);
        assertThat(input.getAmount()).isEqualTo(0L);
    }

    @Test
    public void addAmountShouldReturnLiquidWhenAddedLiquid(){
        Liquid input = new Liquid(9000L);
        Water testWater = new Water(1L);
        Liquid result = testWater.addLiquid(input);
        assertThat(result != testWater).isFalse();
        assertThat(result instanceof Water).isTrue();
        assertThat(result.getAmount()).isEqualTo(9001);
        assertThat(testWater.getAmount()).isEqualTo(9001L);
        assertThat(input.getAmount()).isEqualTo(0L);
    }

}