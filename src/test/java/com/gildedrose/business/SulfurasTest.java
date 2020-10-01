package com.gildedrose.business;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SulfurasTest {
    @Test
    @DisplayName("Sulfura instance")
    public void sulfurasGenerator()throws InvalidInputException {
        Sulfuras sulfuras = new Sulfuras(0, 80);
        String expectedName = "Sulfuras, Hand of Ragnaros" ;
        String actualName = sulfuras.getName();
        assertEquals(expectedName, actualName);
        int expectedSellIn = 0, actualSellIn = sulfuras.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 80, actualQuality = sulfuras.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

    @Test
    @DisplayName("toString() Sulfuras test")
    public void toStringTest() throws InvalidInputException {
        Sulfuras sulfuras = new Sulfuras(0, 80);
        System.out.println("Sulfuras toString() test::");
        System.out.println(sulfuras.toString());
    }

    @Test
    @DisplayName("updateQuality Sulfuras:: no chang in sellIn, max quality 80")
    public void updateQualitySulfuras()throws InvalidInputException{
        Sulfuras sulfuras = new Sulfuras(0, 80);
        sulfuras.updateQuality();
        int expectedSellIn = 0, actualSellIn = sulfuras.getSellIn(), deltaSelIn = 0;
        int expectedQuality = 80 , actualQuality = sulfuras.getQuality(), deltaQuality = 0;
        assertEquals(expectedSellIn, actualSellIn, deltaSelIn);
        assertEquals(expectedQuality, actualQuality, deltaQuality);
    }

}