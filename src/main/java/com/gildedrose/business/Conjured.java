package com.gildedrose.business;

public class Conjured extends ItemBuilder{
    private static final String name = "Conjured Mana Cake";
    public Conjured(int sellIn, int quality) throws InvalidInputException{
        super(Conjured.name, sellIn, quality);
        if(quality > Conjured.MAX_QUALITY){
            throw new InvalidInputException("The quality of Conjured cannot be more than 50");
        }
        if(quality < MINIMUM_QUALITY){
            throw new InvalidInputException("The quality of in Conjured cannot be negative");
        }

    }

    //Degrade in quality twice as fast as normal items,so if Conjured gets sell decrease twice = 2  is not double of twice = 4
    @Override
    public void updateQuality() {
        int getSell = getSellIn();
        if (getSell > 0) {
            qualityCalculation(-2);
        } else {
            qualityCalculation(-4);
        }
        setSellIn();
    }
}
