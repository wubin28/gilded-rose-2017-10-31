package com.wubinben.katas;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int updateQuality() {
        return notGreaterThanFifty(sellIn > 10 ? quality + 1 : (sellIn > 5 ? quality + 2 : (sellIn > 0 ? quality + 3 : 0)));
    }
}
