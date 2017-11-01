package com.wubinben.katas;

public class Normal extends Item {
    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Item updateSellInAndQuality() {
        return new Normal(super.name, super.updateSellIn(), updateQuality());
    }

    private int updateQuality() {
        return notLessThanZero((sellIn <= 0) ? quality - 2 : quality - 1);
    }

}
