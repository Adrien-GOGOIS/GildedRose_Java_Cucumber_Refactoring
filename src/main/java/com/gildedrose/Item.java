package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update() {
        if (isSulfuras()) {
            updateSulfuras();
        }

        if (isAgedBrie()) {
            updateAgedBrie();
        }

        if (isConcertTicket()) {
            updateTicket();
        }

        if(isConjuredItem()) {
            updateConjuredItem();
        }

        if (isStandardItem()) {
            decreaseQuality();
        }
    }

    public void decreaseQuality() {
        if (quality > 0) {
            quality -= 1;
        }
        sellIn -= 1;
    }

    public void updateAgedBrie() {
        if (quality < 50) {
            quality += 1;
        }
        sellIn -= 1;
    }

    public void updateTicket() {
        quality += 1;
        if (sellIn < 11) {
            quality += 1;
        }
        if (sellIn < 6) {
            quality += 1;
        }
        if (sellIn < 0) {
            quality = 0;
        }
        sellIn -= 1;
    }

    public void updateSulfuras() {
        quality += 0;
        sellIn += 0;
    }

    public void updateConjuredItem() {
        if (quality < 50) {
            quality -= 2;
        }
        sellIn -= 1;
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    private boolean isConcertTicket() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConjuredItem() {
        return name.equals("Conjured Mana Cake");
    }

    private boolean isStandardItem() {
        return (!name.equals("Aged Brie") && !name.equals("Sulfuras, Hand of Ragnaros") && !name.equals("Backstage passes to a TAFKAL80ETC concert") && !name.equals("Conjured Mana Cake"));
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
