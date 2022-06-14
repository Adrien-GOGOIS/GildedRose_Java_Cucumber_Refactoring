package com.gildedrose;

import java.util.List;

class GildedRose {
    List<Item> items;
    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            if (!isSulfuras(item)) {

                if (isAgedBrie(item)) {
                    increaseQuality(item);

                } else if (isConcertTicket(item)) {
                    increaseTicketQuality(item);

                } else {
                    decreaseQuality(item);
                }

                item.sellIn -= 1;
            }
        }
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    public void increaseTicketQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
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
}
