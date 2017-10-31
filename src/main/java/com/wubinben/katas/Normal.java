package com.wubinben.katas;

public class Normal extends Item {
    Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    public Item updateSellInAndQuality() {
        return new Normal(this.name, sellIn - 1, notLessThanZero((sellIn <= 0) ? quality - 2 : quality - 1));
    }
}
