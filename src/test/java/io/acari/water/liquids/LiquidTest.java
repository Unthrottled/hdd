package io.acari.water.liquids;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class LiquidTest {

    @Test
    public void getAmountShouldThrowIllegalArgumentExceptionWhenGivenNegativeNumber() {
        try {
            new Liquid(-1);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void getAmountShouldReturnConstructedValueWhenValid() {
        long input = 1L;
        long expectedResult = 1L;
        Liquid testGuy = new Liquid(input);
        long actualResult = testGuy.getAmount();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void equalsShouldReturnFalseWhenNull() {
        assertFalse(new Liquid(0).equals(null));
    }

    @Test
    public void equalsShouldReturnTrueWhenSameAmount() {
        assertTrue(new Liquid(0).equals(new Liquid(0)));
    }

    @Test
    public void equalsShouldReturnTrueWhenSameObject() {
        Liquid liquid = new Liquid(0);
        assertTrue(liquid.equals(liquid));
    }

    @Test
    public void addLiquidShouldReturnLiquidWithCurrentVolumePlusAmountAddedAndDrainLiquidProvided() {
        Liquid input = new Liquid(10L);
        Liquid testLiquid = new Liquid(42L);
        Liquid result = testLiquid.addLiquid(input);
        assertThat(testLiquid == result).isTrue();
        assertThat(input.getAmount()).isEqualTo(0L);
        assertThat(result.getAmount()).isEqualTo(52L);
    }

    @Test
    public void reduceVolumeByShouldReturnNewInstanceWithLiquidProvidedAndCurrentInstantDrained() {
        Liquid testLiquid = new Liquid(100L);
        Liquid result = testLiquid.reduceVolumeBy(31L).get();
        assertThat(testLiquid != result).isTrue();
        assertThat(result.getAmount()).isEqualTo(31L);
        assertThat(testLiquid.getAmount()).isEqualTo(69L);
    }

    @Test
    public void reduceVolumeByShouldNotDoAnythingWhenGivenNegative() {
        Liquid testLiquid = new Liquid(100L);
        Optional<? extends Liquid> result = testLiquid.reduceVolumeBy(-1L);
        assertThat(result.isPresent()).isFalse();
        assertThat(testLiquid.getAmount()).isEqualTo(100L);
    }

    @Test
    public void reduceVolumeByShouldNotDoAnythingWhenGivenGreaterThanCurrentVolume() {
        Liquid testLiquid = new Liquid(100L);
        Optional<? extends Liquid> result = testLiquid.reduceVolumeBy(101L);
        assertThat(result.isPresent()).isFalse();
        assertThat(testLiquid.getAmount()).isEqualTo(100L);
    }
}