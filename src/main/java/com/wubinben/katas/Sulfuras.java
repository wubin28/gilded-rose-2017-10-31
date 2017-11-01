package com.wubinben.katas;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public Item updateSellInAndQuality() {
        return new Sulfuras(super.name, super.updateSellIn(), super.quality);
    }
}
