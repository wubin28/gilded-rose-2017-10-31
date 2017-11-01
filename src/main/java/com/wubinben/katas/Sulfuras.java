package com.wubinben.katas;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int updateQuality() {
        return super.quality;
    }

}
