package io.acari.water;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Forged in the flames of battle by alex.
 */
public class WaterRepositoryTest {


  @Test
  public void fillContainerHalfWayShouldReturnAContainerThatIsHalfFull() {
    WaterSupply waterSupply = Mockito.mock(WaterSupply.class);
    WaterRepository waterRepository = new WaterRepository(waterSupply);
  }
}