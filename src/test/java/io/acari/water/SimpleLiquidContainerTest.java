package io.acari.water;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleLiquidContainerTest {


    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenGivenNegativeValue() {
        try {
            new SimpleLiquidContainer(-1);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void fetchTotalCapacityShouldReturnValueConstructedWith() {
        long input = 500L;
        long expectedResult = 500L;
        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
        long result = testSubject.fetchTotalCapacity();
        assertEquals(expectedResult, result);
    }

//    @Test
//    public void storeWaterShouldStoreReturnMaxCapacityWhenGivenValueEqualToTotalCapacity() {
//        long input = 500L;
//        long expectedResult = 500L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        long result = testSubject.storeWater(input);
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void storeWaterShouldStoreReturnMaxCapacityWhenGivenValueGreaterThanTotalCapacity() {
//        long input = 500L;
//        long expectedResult = 500L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        long result = testSubject.storeWater(input + 1L);
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void storeWaterShouldStoreReturnDesiredAmountWhenGivenValueLessThanTotalCapacity() {
//        long input = 500L;
//        long expectedResult = 499L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        long result = testSubject.storeWater(input - 1L);
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void storeWaterShouldStoreReturnMaxCapacityWhenGivenValueOneLessThanTotalCapacityTwice() {
//        long input = 500L;
//        long expectedResult = 500L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        long testInput = input - 1L;
//        testSubject.storeWater(testInput);
//        long result = testSubject.storeWater(testInput);
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void storeWaterShouldStoreThrowIllegalArgumentExceptionWhenGivenNegativeOne() {
//        SimpleLiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(1);
//        try {
//            simpleLiquidContainer.storeWater(-1);
//            fail();
//        } catch (IllegalArgumentException ignored) {
//        }
//    }
//
//    @Test
//    public void fetchCurrentVolumeReturnMaxCapacityWhenGivenValueEqualToTotalCapacity() {
//        long input = 500L;
//        long expectedResult = 500L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        testSubject.storeWater(input);
//        long result = testSubject.fetchCurrentVolume();
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void fetchCurrentVolumeReturnMaxCapacityWhenGivenValueGreaterThanTotalCapacity() {
//        long input = 500L;
//        long expectedResult = 500L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        testSubject.storeWater(input + 1);
//        long result = testSubject.fetchCurrentVolume();
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void fetchCurrentVolumeReturnDesiredAmountWhenGivenValueLessThanTotalCapacity() {
//        long input = 500L;
//        long expectedResult = 499L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        testSubject.storeWater(input - 1);
//        long result = testSubject.fetchCurrentVolume();
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void fetchCurrentVolumeReturnMaxCapacityWhenGivenValueOneLessThanTotalCapacityTwice() {
//        long input = 500L;
//        long expectedResult = 500L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        testSubject.storeWater(input - 1);
//        testSubject.storeWater(input - 1);
//        long result = testSubject.fetchCurrentVolume();
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void fetchCurrentVolumeShouldReturnZeroWhenNoWaterHasBeenStored() {
//        long input = 500L;
//        long expectedResult = 0L;
//        SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
//        long result = testSubject.fetchCurrentVolume();
//        assertEquals(expectedResult, result);
//    }
}