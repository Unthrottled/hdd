package io.acari.water.liquids;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaterFaucetTest {

    @Test
    public void fetchWaterShouldReturnDesiredAmount() {
        Water expected =  new Water(42L);//if getting real water would be so easy!
        WaterFaucet waterFaucet = new WaterFaucet();
        Water result = waterFaucet.fetchWater(42L);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void fetchWaterShouldReturnDesiredAmountWhenGivenZero() {
        Water expected =  new Water(0L);
        WaterFaucet waterFaucet = new WaterFaucet();
        Water result = waterFaucet.fetchWater(0L);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void fetchWaterShouldThrowIllegalArgumentExceptionWhenGivenNumberLessThanZero() {
        try {
            new WaterFaucet().fetchWater(-1L);
            fail();
        } catch (IllegalArgumentException ignore){}
    }
}