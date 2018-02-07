package io.acari.water;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Forged in the flames of battle by alex.
 */
public class SimpleLiquidContainerTest {


  @Test
  public void constructorShouldThrowIllegalArgumentExceptionWhenGivenNegativeValue() {
    try{
      new SimpleLiquidContainer(-1);
      fail();
    } catch (IllegalArgumentException ignored){
    }
  }

  @Test
  public void fetchTotalCapacityShouldReturnValueConstructedWith() {
    long input = 500L;
    long expectedResult = 500L;
    SimpleLiquidContainer testSubject = new SimpleLiquidContainer(input);
    long result = testSubject.fetchCurrentVolume();
    assertEquals(expectedResult, result);
  }

  @Test
  public void storeWaterShouldStoreReturnMaxCapacityWhenGivenValueEqualToTotalCapacity() {

  }

  @Test
  public void storeWaterShouldStoreReturnMaxCapacityWhenGivenValueGreaterThanTotalCapacity() {

  }

  @Test
  public void storeWaterShouldStoreReturnDesiredAmountWhenGivenValueLessThanTotalCapacity() {

  }

  @Test
  public void storeWaterShouldStoreReturnMaxCapacityWhenGivenValueOneLessThanTotalCapacityTwice() {

  }

  @Test
  public void storeWaterShouldStoreThrowIllegalArgumentExceptionWhenGivenNegativeOne() {

  }

  @Test
  public void fetchCurrentVolumeReturnMaxCapacityWhenGivenValueEqualToTotalCapacity() {

  }

  @Test
  public void fetchCurrentVolumeReturnMaxCapacityWhenGivenValueGreaterThanTotalCapacity() {

  }

  @Test
  public void fetchCurrentVolumeReturnDesiredAmountWhenGivenValueLessThanTotalCapacity() {

  }

  @Test
  public void fetchCurrentVolumeReturnMaxCapacityWhenGivenValueOneLessThanTotalCapacityTwice() {

  }

  @Test
  public void fetchCurrentVolumeShouldReturnZeroWhenNoWaterHasBeenStored() {
  }
}