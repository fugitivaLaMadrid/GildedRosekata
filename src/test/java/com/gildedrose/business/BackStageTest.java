package com.gildedrose.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackStageTest {
    @Test
    @DisplayName("Backstage instance - testing GetSellIn and getQuality")
    public void backstageGenerator() throws InvalidInputException{
        BackStage backstage = new BackStage( 15, 20);
        String expectedName = "Backstage passes to a TAFKAL80ETC concert";
        String actualName = backstage.getName();
        assertEquals(expectedName, actualName);

        int expectedSellIn = 15, actualSellIn = backstage.getSellIn(), deltaSellIn = 0 ;
        int expectedQuality = 20, actualQuality = backstage.getQuality(), deltaQuality = 0 ;
        assertEquals(expectedQuality, actualQuality, deltaQuality);
        assertEquals(expectedSellIn, actualSellIn, deltaSellIn);
    }

    @Test
    @DisplayName("toString() Backstage test")
    public void toStringTest() throws InvalidInputException{
        BackStage backstage = new BackStage( 15, 20);
        System.out.println("toString() Backstage test::");
        System.out.println(backstage.toString());
    }

    @Test
    @DisplayName("Update getSellIn and getQuality over Ten:: decrease sellIn by 1, but increase quality by 1")
    public void updateQualityOverTen() throws InvalidInputException{
        BackStage backstage = new BackStage( 15, 10);
        backstage.updateQuality();
        int expectedSellIn = 14, actualSellIn = backstage.getSellIn(), deltaSellIn = 0 ;
        int expectedQuality = 11, actualQuality = backstage.getQuality(), deltaQuality = 0 ;
        assertEquals(expectedSellIn, actualSellIn, deltaSellIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update getQuality over Five:: decrease sellIn by 1, but increase quality by 2")
    public void updateQualityOverFive() throws InvalidInputException{
        BackStage backstage = new BackStage( 6, 5);
        backstage.updateQuality();

        int expectedSellIn = 5, actualSellIn = backstage.getSellIn(), deltaSellIn = 0 ;
        int expectedQuality = 7, actualQuality = backstage.getQuality(), deltaQuality = 0 ;
        assertEquals(expectedSellIn, actualSellIn, deltaSellIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update getQuality over Zero:: decrease sellIn by 1, but increase quality by 3")
    public void updateQualityOverZero() throws InvalidInputException{
        BackStage backstage = new BackStage( 5, 0);
        backstage.updateQuality();
        int expectedSellIn = 4, actualSellIn = backstage.getSellIn(), deltaSellIn = 0 ;
        int expectedQuality = 3, actualQuality = backstage.getQuality(), deltaQuality = 0 ;
        assertEquals(expectedSellIn, actualSellIn, deltaSellIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update getQuality expired:: decrease sellIn by 1, and drop quality to 0")
    public void updateQualityBackStageExpired() throws InvalidInputException{
        BackStage backstage = new BackStage( 0, 20);
        backstage.updateQuality();
        int expectedSellIn = -1, actualSellIn = backstage.getSellIn(), deltaSellIn = 0 ;
        int expectedQuality = 0, actualQuality = backstage.getQuality(), deltaQuality = 0 ;
        assertEquals(expectedSellIn, actualSellIn, deltaSellIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("Update getQuality never more than 50: decrease sellIn by 1, but, set quality max 50")
    public void qualityBackStageMax50() throws InvalidInputException{
        BackStage backstage = new BackStage( 5, 50);
        backstage.updateQuality();
        int expectedSellIn1 = 4, actualSellIn1 = backstage.getSellIn(), deltaSellIn1 = 0 ;
        int expectedQuality1 = 50, actualQuality1 = backstage.getQuality(), deltaQuality1 = 0 ;
        assertEquals(expectedSellIn1, actualSellIn1, deltaSellIn1);
        assertEquals(expectedQuality1, actualQuality1, deltaQuality1);

        backstage = new BackStage(10, 49);
        backstage.updateQuality();
        int expectedSellIn2 = 9, actualSellIn2 = backstage.getSellIn(), deltaSellIn2 = 0 ;
        int expectedQuality2 = 50, actualQuality2 = backstage.getQuality(), deltaQuality2 = 0 ;
        assertEquals(expectedSellIn2, actualSellIn2, deltaSellIn2);
        assertEquals(expectedQuality2, actualQuality2, deltaQuality2);
    }

}