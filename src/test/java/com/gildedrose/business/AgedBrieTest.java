package com.gildedrose.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class gedBrieTest {
    @Test
    @DisplayName("AgedBrie instance")
    public void agedBrieGenerator() throws InvalidInputException {

        AgedBrie agedBrie = new AgedBrie( 2, 0);
        String expectedName = "Aged Brie";
        String actualName = agedBrie.getName();
        assertEquals(expectedName, actualName);

        int expectedSellIn =2, actualSellIn = agedBrie.getSellIn(), deltaSellIn = 0 ;
        int expectedQuality = 0, actualQuality = agedBrie.getQuality(),deltaQuality =0 ;
        assertEquals(expectedSellIn,actualSellIn , deltaSellIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("toString() Aged Brie test")
    public void toStringTest() throws InvalidInputException {
        AgedBrie agedBrie = new AgedBrie( 2, 0);
        System.out.println("toString() Aged Brie test::");
        System.out.println(agedBrie.toString());
    }

    @Test
    @DisplayName("Update quality Brie cheese:: Decrease sellIn by 1, but the older get increase quality by 1")
    public void updateQualityBrie() throws InvalidInputException {
        AgedBrie agedBrie = new AgedBrie( 2, 10);
        agedBrie.updateQuality();
        int expectedSellIn = 1, actualSellIn = agedBrie.getSellIn(),deltaSellIn = 0 ;
        int expectedQuality = 11, actualQuality =agedBrie.getQuality(), deltaQuality = 0 ;
        assertEquals(expectedSellIn,actualSellIn , deltaSellIn);
        assertEquals(expectedQuality,actualQuality , deltaQuality);
    }

    @Test
    @DisplayName("Update quality Brie expired:: Decrease sellIn by 1, but not selling increase quality twice")
    public void updateQualityBrieExpired() throws InvalidInputException{
        AgedBrie agedBrie = new AgedBrie( 0, 0);
        agedBrie.updateQuality();
        int expectedSellIn = -1, actualSellIn = agedBrie.getSellIn(), deltaSellIn = 0;
        int expectedQuality = 2, actualQuality =agedBrie.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSellIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update getQuality never more than 50:: By sellIn decrease by 1, quality setup to 50")
    public void qualityMax50() throws InvalidInputException{
        AgedBrie agedBrie = new AgedBrie( -1, 50);
        agedBrie.updateQuality();
        int expectedSellIn1 = -2, actualSellIn1 = agedBrie.getSellIn(), deltaSellIn1 = 0;
        int expectedQuality1 = 50, actualQuality1 =agedBrie.getQuality(), deltaQuality1 = 0 ;
        assertEquals(expectedSellIn1, actualSellIn1, deltaSellIn1);
        assertEquals(expectedQuality1, actualQuality1, deltaQuality1);

        //create new instance with a new value on quality = 49
        agedBrie = new AgedBrie( -1, 49);
        agedBrie.updateQuality();
        int expectedSellIn2 = -2, actualSellIn2 = agedBrie.getSellIn(), deltaSellIn2 = 0;
        int expectedQuality2 = 50, actualQuality2 =agedBrie.getQuality(), deltaQuality2 = 0 ;
        assertEquals(expectedSellIn2, actualSellIn2, deltaSellIn2);
        assertEquals(expectedQuality2, actualQuality2, deltaQuality2);
    }
}