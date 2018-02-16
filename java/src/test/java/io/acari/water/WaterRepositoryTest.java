package io.acari.water;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class WaterRepositoryTest {


  @Test
  public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFullWheSupplyHasLessThanAsked() {
    WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
    Mockito.when(waterSupply.fetchWater(250L)).thenReturn(20L);
    Mockito.when(waterSupply.maximumFetchableWater()).thenReturn(20L);
    Mockito.when(waterSupply.fetchWater(20L)).thenReturn(20L);
    Mockito.when(waterSupply.fetchWater(10L)).thenReturn(10L);
    WaterRepository testSubject = new WaterRepository(waterSupply);
    LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(500);
    LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
    assertEquals(250, result.fetchCurrentVolume());
  }


  @Test
  public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFullWheSupplyHasEnough() {
    WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
    Mockito.when(waterSupply.fetchWater(250L)).thenReturn(250L);
    Mockito.when(waterSupply.maximumFetchableWater()).thenReturn(500L);
    WaterRepository testSubject = new WaterRepository(waterSupply);
    LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(500);
    LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
    assertEquals(250, result.fetchCurrentVolume());
  }


  @Test
  public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFullWheSupplyHasLessThanAsked_II() {
    WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
    Mockito.when(waterSupply.fetchWater(500L)).thenReturn(50L);
    Mockito.when(waterSupply.maximumFetchableWater()).thenReturn(50L);
    Mockito.when(waterSupply.fetchWater(50L)).thenReturn(50L);
    WaterRepository testSubject = new WaterRepository(waterSupply);
    LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(1000);
    LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
    assertEquals(500, result.fetchCurrentVolume());
  }


  @Test
  public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFullWheSupplyHasEnough_II() {
    WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
    Mockito.when(waterSupply.fetchWater(500L)).thenReturn(500L);
    Mockito.when(waterSupply.maximumFetchableWater()).thenReturn(1000L);
    WaterRepository testSubject = new WaterRepository(waterSupply);
    LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(1000);
    LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
    assertEquals(500, result.fetchCurrentVolume());
  }
}