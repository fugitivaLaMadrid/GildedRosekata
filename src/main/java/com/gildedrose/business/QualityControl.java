package com.gildedrose.business;

public interface QualityControl {
    int MAX_QUALITY = 50;
    int MINIMUM_QUALITY = 0;
    int MAX_QUALITY_LEGENDARY = 80;
    int SELL_IN_LEGENDARY = 0;
    public void updateQuality();
    public void qualityCalculation(int value);
}
