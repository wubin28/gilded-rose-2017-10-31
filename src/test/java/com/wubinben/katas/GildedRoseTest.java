package com.wubinben.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {
    @Test
    public void at_the_end_of_each_day_our_system_lowers_sellIn_and_quality_values_by_1_if_sellIn_is_greater_than_0_for_normal_items() {
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(1, 20);

        NormalItem updatedNormalItem = normalItem.updateSellInAndQuality();

        assertThat(updatedNormalItem.getSellIn(), is(0));
        assertThat(updatedNormalItem.getQuality(), is(19));
    }
}
