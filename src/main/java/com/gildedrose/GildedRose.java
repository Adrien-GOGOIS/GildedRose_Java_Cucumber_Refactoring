package com.gildedrose;

import java.util.List;

class GildedRose {
    List<Item> items;
    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            if (isSulfuras(item)) {
                updateSulfuras(item);
            }

            if (isAgedBrie(item)) {
                updateAgedBrie(item);
            }

            if (isConcertTicket(item)) {
                updateTicket(item);
            }

            if(isConjuredItem(item)) {
                updateConjuredItem(item);
            }

            if (isStandardItem(item)) {
                decreaseQuality(item);
            }
        }
    }
    
    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
        item.sellIn -= 1;
    }

    public void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        item.sellIn -= 1;
    }
    
    public void updateTicket(Item item) {
        item.quality += 1;
        if (item.sellIn < 11) {
            item.quality += 1;
        }
        if (item.sellIn < 6) {
            item.quality += 1;
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        item.sellIn -= 1;
    }

    public void updateSulfuras(Item item) {
        item.quality += 0;
        item.sellIn += 0;
    }

    public void updateConjuredItem(Item item) {
        if (item.quality < 50) {
            item.quality -= 2;
        }
        item.sellIn -= 1;
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isConcertTicket(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConjuredItem(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

    private boolean isStandardItem(Item item) {
        return (!item.name.equals("Aged Brie") && !item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Conjured Mana Cake"));
    }

}
