package com.gildedrose.business;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QualityControlTest {
    @Test
    @DisplayName("ItemBuilder Generator")
    public void itemBuilderGenerator() {
        QualityControl qualityControl = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        String expectedName = "+5 Dexterity Vest";
        String actualName = ((ItemBuilder)qualityControl).getName();
        assertEquals(expectedName, actualName);

        int expectedSellIn = 10, actualSellIn = ((ItemBuilder)qualityControl).getSellIn(), deltaSelIn = 0;
        int expectedQuality = 20, actualQuality = ((ItemBuilder)qualityControl).getQuality(),  deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("toString() ItemBuilder test")
    public void toStringTest() {
        QualityControl normal = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        System.out.println(normal.toString());
    }

    @Test
    @DisplayName("updateQuality ItemBuilder:: decrease sellin by 1, quality by 1")
    public void updateQualityItemBuilder() {
        QualityControl qualityControl = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        qualityControl.updateQuality();
        int expectedSellIn = 9, actualSellIn =  ((ItemBuilder)qualityControl).getSellIn(), deltaSelIn = 0;
        int expectedQuality = 19, actualQuality = ((ItemBuilder)qualityControl).getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update Quality ItemBuilder Expired:: decrease sellIn by 1, quality decrease by 2")
    public void updateQualityItemBuilderExpired() {
        QualityControl qualityControl = new ItemBuilder("+5 Dexterity Vest", 0, 20);
        qualityControl.updateQuality();
        int expectedSellIn = -1, actualSellIn = ((ItemBuilder)qualityControl).getSellIn(), deltaSelIn = 0;
        int expectedQuality = 18, actualQuality = ((ItemBuilder)qualityControl).getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update quality Minimum Zero::  decrease sellIn by 1, but quality set to 0")
    public void qualityMinimumZero() {
        QualityControl qualityControl = new ItemBuilder("+5 Dexterity Vest", 10, 0);
        qualityControl.updateQuality();
        int expectedSellIn = 9, actualSellIn = ((ItemBuilder)qualityControl).getSellIn(), deltaSelIn = 0;
        int expectedQuality = 0 ,actualQuality = ((ItemBuilder)qualityControl).getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

}