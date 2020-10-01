package com.gildedrose.business;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    private List<QualityControl> inventoryList = new ArrayList<>();

    public List<QualityControl> inventoryList() {
        return this.inventoryList;
    }

    public void addItem(QualityControl item) {
        inventoryList().add(item);
    }

    public void updateQuality() {
        for (QualityControl item : inventoryList()) {
            item.updateQuality();
        }

    }
    @Override
    public String toString() {
        StringBuilder item = new StringBuilder();
        for (QualityControl qualityControl : inventoryList()) {
            item.append(qualityControl.toString());
            item.append('\n');
        }
        return item.toString();
    }
}