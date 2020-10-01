package com.gildedrose.business;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    @DisplayName("Item instance")
    public void itemGenerator() {

        Item item = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        String expectedName1 = "+5 Dexterity Vest";
        String actualName1 = ((ItemBuilder)item).getName();
        assertEquals(expectedName1, actualName1);

        int expectedSellIn1 = 10, actualSellIn1 = ((ItemBuilder)item).getSellIn(),deltaSelIn1 = 0;
        int expectedQuality1 = 20, actualQuality1 = ((ItemBuilder)item).getQuality(), deltaQuality1 = 0;
        assertEquals(expectedSellIn1, actualSellIn1, deltaSelIn1);
        assertEquals(expectedQuality1, actualQuality1, deltaQuality1);
        System.out.println(item);

        item = new ItemBuilder("Elixir of the Mongoose", 5, 7);
        String expectedName2 = "Elixir of the Mongoose";
        String actualName2 = ((ItemBuilder)item).getName();
        assertEquals(expectedName2, actualName2);
        int expectedSellIn2 = 5, actualSellIn2 = ((ItemBuilder)item).getSellIn(),deltaSelIn2 = 0;
        int expectedQuality2 = 7, actualQuality2 = ((ItemBuilder)item).getQuality(), deltaQuality2 = 0;
        assertEquals(expectedSellIn2, actualSellIn2, deltaSelIn2);
        assertEquals(expectedQuality2, actualQuality2, deltaQuality2);
        System.out.println(item);
    }

}