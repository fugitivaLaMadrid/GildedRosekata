package com.gildedrose.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConjuredTest {
    @Test
    @DisplayName("Conjured instance")
    public void conjuredGenerator() throws InvalidInputException{
        Conjured conjured = new Conjured(3, 6);
        String expectedName = "Conjured Mana Cake";
        String actualName = conjured.getName();
        assertEquals(expectedName, actualName);

        int expectedSellIn = 3, actualSellIn = conjured.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 6, actualQuality = conjured.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("toString() Conjured test")
    public void toStringTest() throws InvalidInputException{
        Conjured conjured = new Conjured(3, 6);
        System.out.println("toString() Conjured test::");
        System.out.println(conjured.toString());
    }

    @Test
    @DisplayName("Update quality Conjured:: Decrease sellIn by 1 and decrease quality by 2")
    public void updateQualityConjured() throws InvalidInputException{
        Conjured conjured = new Conjured( 3, 10);
        conjured.updateQuality();
        int expectedSellIn = 2, actualSellIn = conjured.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 8, actualQuality = conjured.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("updateQuality Conjured Just Expired:: sellIn reached 0 decrease by 1, conjure decrease twice, so decrease by 4")
    public void updateQualityConjuredJustExpired() throws InvalidInputException{
        Conjured conjured = new Conjured( 0, 4);
        conjured.updateQuality();
        int expectedSellIn1 = -1, actualSellIn1 = conjured.getSellIn(), deltaSelIn1 = 0;
        int expectedQuality1 = 0,  actualQuality1 = conjured.getQuality(), deltaQuality1 = 0;
        assertEquals(expectedSellIn1, actualSellIn1, deltaSelIn1);
        assertEquals(expectedQuality1, actualQuality1, deltaQuality1);

        conjured = new Conjured(-1, 10);
        conjured.updateQuality();
        int expectedSellIn2 = -2, actualSellIn2 = conjured.getSellIn(), deltaSelIn2 = 0;
        int expectedQuality2 = 6, actualQuality2 = conjured.getQuality(), deltaQuality2 = 0;
        assertEquals(expectedSellIn2, actualSellIn2, deltaSelIn2);
        assertEquals(expectedQuality2, actualQuality2, deltaQuality2);
    }

    @Test
    @DisplayName("Quality minimum Zero:: decrease sellIn by 1, quality is never negative")
    public void qualityMinimumZero() throws InvalidInputException {
        Conjured conjured = new Conjured( -1, 1);
        conjured.updateQuality();
        int expectedSellIn1 = -2, actualSellIn1 = conjured.getSellIn(), deltaSelIn1 = 0;
        int expectedQuality1 = 0, actualQuality1 = conjured.getQuality(), deltaQuality1 = 0;
        assertEquals(expectedSellIn1, actualSellIn1, deltaSelIn1);
        assertEquals(expectedQuality1, actualQuality1, deltaQuality1);

        conjured = new Conjured(-1, 0);
        conjured.updateQuality();
        int expectedSellIn2 = -2, actualSellIn2 = conjured.getSellIn(), deltaSelIn2 = 0;
        int expectedQuality2 = 0, actualQuality2 = conjured.getQuality(), deltaQuality2 = 0;
        assertEquals(expectedSellIn2, actualSellIn2, deltaSelIn2);
        assertEquals(expectedQuality2, actualQuality2, deltaQuality2);
    }
}