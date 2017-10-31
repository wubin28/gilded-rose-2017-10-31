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

    @Test
    public void once_the_sell_by_date_has_passed_quality_of_normal_items_degrades_twice_as_fast() {
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 20);

        NormalItem updatedNormalItem = normalItem.updateSellInAndQuality();

        assertThat(updatedNormalItem.getSellIn(), is(-1));
        assertThat(updatedNormalItem.getQuality(), is(18));
    }

    @Test
    public void the_quality_of_normal_items_should_be_greater_than_or_equal_to_0() {
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 0);

        NormalItem updatedNormalItem = normalItem.updateSellInAndQuality();

        assertThat(updatedNormalItem.getSellIn(), is(-1));
        assertThat(updatedNormalItem.getQuality(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_normal_items_should_be_no_more_than_50() {
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 51);
    }
}
