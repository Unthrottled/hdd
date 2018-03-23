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
}