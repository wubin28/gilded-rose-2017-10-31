package com.wubinben.katas;

public class AgedBrie {
    private final int sellIn;
    private final int quality;

    private AgedBrie(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static AgedBrie newInstanceWithSellInAndQuality(int sellIn, int quality) {
        return new AgedBrie(sellIn, quality);
    }

    public AgedBrie updateSellInAndQuality() {
        return new AgedBrie(this.sellIn - 1, this.quality);
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }
}
