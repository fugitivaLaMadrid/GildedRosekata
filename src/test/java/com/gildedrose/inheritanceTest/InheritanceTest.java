package com.gildedrose.inheritanceTest;

import com.gildedrose.business.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
public class InheritanceTest {
    @Test
    @DisplayName("toString() ItemBuilder")
    public void toStringTest() {
        ItemBuilder itemBuilder = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        System.out.println("toString() ItemBuilder test::");
        System.out.println(itemBuilder.toString());
    }

    @Test
    @DisplayName("updateQuality ItemBuilder")
    public void updateQualityItemBuilder() {
        ItemBuilder itemBuilder = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        itemBuilder.updateQuality();
        String expectedName = "+5 Dexterity Vest", actualName = itemBuilder.getName();
        assertEquals(expectedName, actualName);

        int expectedSellIn = 9, actualSellIn = itemBuilder.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 19, actualQuality = itemBuilder.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("updateQuality ItemBuilder Expired")
    public void updateQualityItemBuilderExpired() {
        ItemBuilder normalItem = new ItemBuilder("+5 Dexterity Vest", 0, 20);
        normalItem.updateQuality();

        int expectedSellIn = -1, actualSellIn = normalItem.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 18, actualQuality = normalItem.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("quality ItemBuilder never negative (Minimum zero)")
    public void qualityItemBuilderMinimZero() {
        ItemBuilder itemBuilder = new ItemBuilder("+5 Dexterity Vest", 10, 0);
        itemBuilder.updateQuality();

        int expectedSellIn = 9, actualSellIn = itemBuilder.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 0, actualQuality = itemBuilder.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("AgedBrie instance")
    public void generateAgedBrie() throws InvalidInputException {
        AgedBrie agedBrie = new AgedBrie(2, 0);
        String expectedName = "Aged Brie",  actualName = agedBrie.getName();
        assertEquals(expectedName, actualName);

        int expectedSellIn = 2, actualSellIn = agedBrie.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 0, actualQuality = agedBrie.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("updateQuality Cheese Brie")
    public void updateQualityCheeseBrie() throws InvalidInputException{
        AgedBrie agedBrie = new AgedBrie( 2, 0);
        agedBrie.updateQuality();

        int expectedSellIn = 1, actualSellIn = agedBrie.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 1, actualQuality = agedBrie.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("gildedRose Test:: Add an Item")
    public void gildedRoseAddItem() throws InvalidInputException{
        GildedRose gildedRoseStore = new GildedRose();
        ItemBuilder itemBuilder = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        AgedBrie agedBrie = new AgedBrie( 2, 0);
        Sulfuras sulfuras = new Sulfuras( 0, 80);
        gildedRoseStore.addItem(itemBuilder);
        gildedRoseStore.addItem(agedBrie);
        gildedRoseStore.addItem(sulfuras);

        int expectedInventorySize = 3, actualInventorySize = gildedRoseStore.inventoryList().size(), deltaInventorySize = 0;
        assertEquals(expectedInventorySize, actualInventorySize, deltaInventorySize);

        //List.of create a new immutable list to store in List<ItemBuilder>
        List<ItemBuilder> items = List.of(itemBuilder, agedBrie, sulfuras);
        Object[] expectedAddItems = items.toArray(), actualAddItems = gildedRoseStore.inventoryList().toArray();
        assertArrayEquals(expectedAddItems, actualAddItems);
        System.out.println("GildedRose addItem test::");
        System.out.println(gildedRoseStore.toString());
    }

    @Test
    @DisplayName("method updateQuality per item")
    public void updateQuality() throws InvalidInputException{
        GildedRose gildedRoseStore = new GildedRose();
        ItemBuilder itemBuilder = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        AgedBrie agedBrie = new AgedBrie(2, 0);
        gildedRoseStore.addItem(itemBuilder);
        gildedRoseStore.addItem(agedBrie);

        int expectedInventorySize = 2, actualInventorySize = gildedRoseStore.inventoryList().size(), deltaInventorySize = 0;
        assertEquals(expectedInventorySize, actualInventorySize, deltaInventorySize);
        System.out.println("Day 0:" + '\n' + gildedRoseStore.toString());
        gildedRoseStore.updateQuality();

        // Cast store to type ItemBuilder to get access getQuality method from ItemBuilder
        //getItem index[0] = quality
        int getItemIndex0Quality = ((ItemBuilder) gildedRoseStore.inventoryList().get(0)).getQuality();
        int expectedQualityIndex0 = 19, actualQualityIndex0 = getItemIndex0Quality, deltaQualityIndex0 = 0;
        assertEquals(expectedQualityIndex0, actualQualityIndex0, deltaQualityIndex0);

        //getItem index[1] = quality
        int getItemIndex1Quality= ((ItemBuilder) gildedRoseStore.inventoryList().get(1)).getQuality();
        int expectedQualityIndex1 = 1, actualQualityIndex1 = getItemIndex1Quality, deltaQualityIndex1 = 0;
        assertEquals(expectedQualityIndex1, actualQualityIndex1, deltaQualityIndex1);
        System.out.println("Day 1:" + '\n' + gildedRoseStore.toString());
    }
}
