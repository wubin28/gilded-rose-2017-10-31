package com.wubinben.katas;

public class Item {
    private final int sellIn;
    private final int quality;
    private final String name;

    public static Item newInstanceWithNameSellInAndQuality(String name, int sellIn, int quality) {
        if (quality > 50 || quality < 0) {
            throw new IllegalArgumentException("The quality of the normal item should be between 0 and 50.");
        }
        return new Item(name, sellIn, quality);
    }

    private Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public Item updateSellInAndQuality() {
        if (this.name.equals("Aged Brie")) {
            return new Item(this.name, sellIn - 1, quality);
        }
        return new Item(this.name, sellIn - 1, notLessThanZero((sellIn <= 0) ? quality - 2 : quality - 1));
    }

    private int notLessThanZero(int quality) {
        return quality <= 0 ? 0 : quality;
    }

    public int getQuality() {
        return this.quality;
    }
}
