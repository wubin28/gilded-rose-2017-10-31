package com.wubinben.katas;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Item updateSellInAndQuality() {
        return new AgedBrie(super.name, super.updateSellIn(), updateQuality());
    }

    private int updateQuality() {
        return notGreaterThanFifty(quality + 1);
    }
}
