package com.wubinben.katas;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Item updateSellInAndQuality() {
        return new BackstagePasses(this.name, sellIn - 1, notGreaterThanFifty(sellIn > 10 ? quality + 1 : (sellIn > 5 ? quality + 2 : (sellIn > 0 ? quality + 3 : 0))));
    }
}
