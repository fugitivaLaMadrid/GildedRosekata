package com.gildedrose.business;

public class Sulfuras extends ItemBuilder {
    private static final String name = "Sulfuras, Hand of Ragnaros";
    public Sulfuras(int sellIn, int quality) throws InvalidInputException{
        super(Sulfuras.name, sellIn, quality);
        if(quality > Sulfuras.MAX_QUALITY_LEGENDARY){
        throw new InvalidInputException("The quality of Sulfuras cannot be more than 80");
        }
        if(sellIn > Sulfuras.SELL_IN_LEGENDARY){
            throw new InvalidInputException("This a legendary item,it's not allow to be sell");
        }
    }
    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality, so not action in updateQuality
    @Override
    public void updateQuality() {}
}
