package com.gildedrose.business;

public class ItemBuilder extends Item implements QualityControl{
    public ItemBuilder(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    protected void setSellIn() {
        this.sellIn = this.getSellIn() - 1;
    }

    public int getQuality() {
        return quality;
    }

    protected void setQuality(int value) {
        quality =value;
    }

    @Override
    public void updateQuality()  {
        if (getSellIn() > MINIMUM_QUALITY) {//At the end of each day their system lowers both(sellIn and quality) values for every item
            qualityCalculation(-1);
        } else {//Once the sell by date has passed, Quality degrades twice as fast
            qualityCalculation(-2);
        }
        setSellIn();

    }


    @Override
    //The Quality of an item is never more than 50
    public void qualityCalculation(int value) {
        if (getQuality() + value > MAX_QUALITY) {
            setQuality(MAX_QUALITY);
        }
        //The Quality of an item is never negative
        else if (getQuality() + value > MINIMUM_QUALITY) {//base on quality will set the value of quality
            setQuality(getQuality()+ value);
        }
        else {//The Quality of an item is never negative, so if is negative set to equality = 0
            setQuality(MINIMUM_QUALITY);
        }
    }

    @Override
    public String toString() {
        StringBuilder itemDescription = new StringBuilder();
        itemDescription.append("name:: " + getName());
        itemDescription.append(", sellIn:: " + getSellIn());
        itemDescription.append(", quality:: " + getQuality());
        return itemDescription.toString();
    }
}
