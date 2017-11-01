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

    public static class Normal extends Item {
        public Normal(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        public Item updateSellInAndQuality() {
            return new Normal(this.name, sellIn - 1, notLessThanZero((sellIn <= 0) ? quality - 2 : quality - 1));
        }
    }

    public static class AgedBrie extends Item {
        public AgedBrie(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        public Item updateSellInAndQuality() {
            return new AgedBrie(this.name, sellIn - 1, notGreaterThanFifty(quality + 1));
        }
    }

    public static class BackstagePasses extends Item {
        public BackstagePasses(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        public Item updateSellInAndQuality() {
            return new BackstagePasses(this.name, sellIn - 1, notGreaterThanFifty(sellIn > 10 ? quality + 1 : (sellIn > 5 ? quality + 2 : (sellIn > 0 ? quality + 3 : 0))));
        }
    }

    public static class Sulfuras extends Item {
        public Sulfuras(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        public Item updateSellInAndQuality() {
            return new Sulfuras(this.name, sellIn - 1, quality);
        }
    }
}
