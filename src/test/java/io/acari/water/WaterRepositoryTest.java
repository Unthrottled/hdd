package io.acari.water;

import io.acari.water.liquids.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class WaterRepositoryTest {


    @Test
    public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFull() {
        WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
        Mockito.when(waterSupply.fetchWater(250L)).thenReturn(new Water(250L));
        WaterRepository testSubject = new WaterRepository(waterSupply);
        LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(500);
        LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
        assertTrue(result.fetchCurrentVolume()
                .map(new Water(250)::equals)
                .orElse(false));
    }


    @Test
    public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFull_II() {
        WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
        Mockito.when(waterSupply.fetchWater(500L)).thenReturn(new Water(500L));
        WaterRepository testSubject = new WaterRepository(waterSupply);
        LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(1000);
        LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
        assertTrue(result.fetchCurrentVolume()
                .map(new Water(500)::equals)
                .orElse(false));
    }


    @Test
    public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFullAndHalfNeedsToBeFloatingPoint() {
        WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
        Mockito.when(waterSupply.fetchWater(131L)).thenReturn(new Water(131L));
        WaterRepository testSubject = new WaterRepository(waterSupply);
        LiquidContainer simpleLiquidContainer = new SimpleLiquidContainer(263);
        LiquidContainer result = testSubject.fillContainerHalfWay(simpleLiquidContainer);
        assertTrue(result.fetchCurrentVolume()
                .map(new Water(131)::equals)
                .orElse(false));
    }


    @Test
    public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFullWhenAlreadyIsHalfFull() {
        WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
        Mockito.when(waterSupply.fetchWater(131L)).thenReturn(new Water(131L));
        WaterRepository testSubject = new WaterRepository(waterSupply);
        LiquidContainer simpleLiquidContainer = Mockito.mock(LiquidContainer.class);
        Liquid moreThanHalf = Mockito.mock(Liquid.class);
        Mockito.when(moreThanHalf.getAmount()).thenReturn(6L);
        Mockito.when(simpleLiquidContainer.fetchCurrentVolume()).thenReturn(Optional.of(moreThanHalf));
        Mockito.when(simpleLiquidContainer.fetchTotalCapacity()).thenReturn(10L);
        testSubject.fillContainerHalfWay(simpleLiquidContainer);
        Mockito.verify(simpleLiquidContainer, Mockito.times(0)).storeLiquid(Mockito.any());
    }


    @Test
    public void fillContainerHalfWayShouldThrowAnExceptionWhenContainerIsMoreThanHalfFull() {
        WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
        Mockito.when(waterSupply.fetchWater(131L)).thenReturn(new Water(131L));
        WaterRepository testSubject = new WaterRepository(waterSupply);
        LiquidContainer simpleLiquidContainer = Mockito.mock(LiquidContainer.class);
        Liquid moreThanHalf = Mockito.mock(Liquid.class);
        Mockito.when(moreThanHalf.getAmount()).thenReturn(6L);
        Mockito.when(simpleLiquidContainer.fetchCurrentVolume()).thenReturn(Optional.of(moreThanHalf));
        Mockito.when(simpleLiquidContainer.fetchTotalCapacity()).thenReturn(10L);
        try {
            testSubject.fillContainerHalfWay(simpleLiquidContainer);
            fail();
        } catch (IllegalStateException ignored) {
        }

    }
}