package com.gildedrose.business;

public class AgedBrie extends ItemBuilder {
     private static final String name = "Aged Brie";
       public AgedBrie(int sellIn, int quality) throws InvalidInputException {
           super(AgedBrie.name, sellIn, quality);
           if(quality > AgedBrie.MAX_QUALITY){
               throw new InvalidInputException("The quality of in cheese Brie cannot be more than 50");
           }
           if(quality < MINIMUM_QUALITY){
               throw new InvalidInputException("The quality of in cheese Brie cannot be negative");
           }
    }

    /**"Aged Brie" increases in Quality the older it gets,
     // quality increase by 1, increases in Quality the older it gets
     * no selling increase twice*/
    //At the end of each day the system lowers the values of SellIn and Quality
    @Override
    public void updateQuality() {
        int getSell = getSellIn();
        if (getSell > 0) {
            qualityCalculation(1);
        } else {//not selling increase twice quality
            qualityCalculation(2);
        }
        setSellIn();
    }
}
