package com.wubinben.katas;

public abstract class Item {
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
        if (name.equals(SULFURAS)) {
            return new Sulfuras(name, sellIn, quality);
        }
        if (name.equals(AGED_BRIE)) {
            return new AgedBrie(name, sellIn, quality);
        }
        if (name.equals(BACKSTAGE_PASSES)) {
            return new BackstagePasses(name, sellIn, quality);
        }
        return new Normal(name, sellIn, quality);
    }

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public abstract Item updateSellInAndQuality();

    int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }

    int notLessThanZero(int quality) {
        return quality <= 0 ? 0 : quality;
    }

    public int getQuality() {
        return this.quality;
    }

    protected int updateSellIn() {
        return sellIn - 1;
    }
}
