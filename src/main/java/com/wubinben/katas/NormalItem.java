package com.wubinben.katas;

public class NormalItem {
    private final int sellIn;
    private final int quality;

    public NormalItem(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public NormalItem updateSellInAndQuality() {
        return new NormalItem(sellIn - 1, notLessThanZero((sellIn <= 0) ? quality - 2 : quality - 1));
    }

    private int notLessThanZero(int quality) {
        return quality <= 0 ? 0 : quality;
    }

    public static NormalItem newInstanceWithSellInAndQuality(int sellIn, int quality) {
        return new NormalItem(sellIn, quality);
    }

    public int getQuality() {
        return this.quality;
    }
}
