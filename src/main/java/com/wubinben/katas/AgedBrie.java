package com.wubinben.katas;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int updateQuality() {
        return notGreaterThanFifty(quality + 1);
    }
}
