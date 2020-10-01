package com.gildedrose.business;

public class BackStage extends ItemBuilder {
    private static final String name = "Backstage passes to a TAFKAL80ETC concert";
    public BackStage(int sellIn, int quality)throws InvalidInputException {
        super(BackStage.name, sellIn, quality);
        if(quality > BackStage.MAX_QUALITY){
            throw new InvalidInputException("The quality of BackStage cannot be more than 50");
        }
        if(quality < BackStage.MINIMUM_QUALITY){
            throw new InvalidInputException("The quality of BackStage cannot be negative");
        }
    }

    //At the end of each day the system lowers the values of SellIn and Quality
    @Override
    public void updateQuality() {
        //change from 11 to 10 to fulfill the requirements,
        // quality increase by 1 when there are more than 10 days to sell the it, increases in Quality as its SellIn value approaches;
        if (getSellIn() > 10) {
            qualityCalculation(1);
        }
        //Change from 6 to 5, to fulfill the requirements
        //Quality increases by 2 when there are 10 days or less
        else if (getSellIn() > 5) {
            qualityCalculation(2);
        }
        //Quality increase by 3 by 3 when there are 5 days or less
        else if (getSellIn() > 0) {
            qualityCalculation(3);
        }
        else {
            //setting to 0 quality, Quality drops to 0 after the concert
            setQuality(0);
        }
        setSellIn();
    }
}
