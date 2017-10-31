package com.wubinben.katas;

public class Item {
    public static final String SULFURAS = "Sulfuras";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes";
    public static final String NORMAL = "Normal";
    final int sellIn;
    final int quality;
    final String name;

    public static Item newInstanceWithNameSellInAndQuality(String name, int sellIn, int quality) {
        if (!name.equals(SULFURAS) && (quality > 50 || quality < 0)) {
            throw new IllegalArgumentException("The quality of the normal item should be between 0 and 50.");
        }
        if (name.equals(NORMAL)) {
            return new Normal(name, sellIn, quality);
        }
        if (name.equals(SULFURAS)) {
            return new Sulfuras(name, sellIn, quality);
        }
        if (name.equals(AGED_BRIE)) {
            return new AgedBrie(name, sellIn, quality);
        }
        return new Item(name, sellIn, quality);
    }

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public Item updateSellInAndQuality() {
        if (this.name.equals(BACKSTAGE_PASSES)) {
            return new Item(this.name, sellIn - 1, notGreaterThanFifty(sellIn > 10 ? quality + 1 : (sellIn > 5 ? quality + 2 : (sellIn > 0 ? quality + 3 : 0))));
        }
        return new Item(this.name, sellIn - 1, notLessThanZero((sellIn <= 0) ? quality - 2 : quality - 1));
    }

    int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }

    int notLessThanZero(int quality) {
        return quality <= 0 ? 0 : quality;
    }

    public int getQuality() {
        return this.quality;
    }
}
