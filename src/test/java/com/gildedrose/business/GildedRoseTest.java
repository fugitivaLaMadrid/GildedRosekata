package com.gildedrose.business;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GildedRoseTest {
    private GildedRose store = null;
    private QualityControl qualityControl = null;
    private AgedBrie agedBrie = null;

    @BeforeEach
    @DisplayName("SetUpStorage")
    public void setupStorage() throws InvalidInputException {
        store = new GildedRose();
        qualityControl = new ItemBuilder("+5 Dexterity Vest", 10, 20);
        agedBrie = new AgedBrie( 2, 0);
    }

    @Test
    @DisplayName("toString() GildedRose test")
    public void toStringTest() throws InvalidInputException {
        store.addItem(agedBrie);
        agedBrie = new AgedBrie( 10, 10);
        store.addItem(agedBrie);
        System.out.println("toString() GildedRose test::");
        System.out.println(store.toString());
    }

    @Test
    @DisplayName("GildedRose addItem test")
    public void addItemTest() {
        store.addItem(qualityControl);
        store.addItem(agedBrie);
        int expected =2, actual = store.inventoryList().size(), delta = 0;// delta - the maximum delta between expected and actual for which both numbers are still considered equal.
        assertEquals(expected,actual , delta);

        List<QualityControl> items = List.of(qualityControl, agedBrie);
        Object[] expectedObject =items.toArray(), actualObject = store.inventoryList().toArray();
        assertArrayEquals(expectedObject, actualObject);//assertEquals(obj1[],obj2[]); it will return true as obj1.
        System.out.println("GildedRose addItem test::");
        System.out.println(store.toString());
    }

    @Test
    @DisplayName("Store update Quality")
    public void updateQuality() {
        store.addItem(qualityControl);
        store.addItem(agedBrie);
        int expected =2, actual = store.inventoryList().size(), delta =0;
        assertEquals(expected, actual , delta);
        System.out.println("Day 0::" + '\n' + store.toString());
        store.updateQuality();

        // cast store type GilderRose to ItemBuilder  to get access to getQuality method from ItemBuilder, and update quality
        ItemBuilder item = (ItemBuilder) store.inventoryList().get(0); //get index[0]=NormalItem
        int expectedItemQuality_index0 = 19, actualItemQuality_index0 = item.getQuality(), deltaQuality = 0 ;
        int expectedItemQuality_index1 = 1,  actualItemQuality_index1 = ((ItemBuilder) (store.inventoryList().get(1))).getQuality(),  deltaQuality1 = 0; //get index[1]=AgedBrie

        assertEquals(expectedItemQuality_index0,actualItemQuality_index0 , deltaQuality);
        assertEquals(expectedItemQuality_index1, actualItemQuality_index1, deltaQuality1);
        System.out.println("Day 1::" + '\n' + store.toString());
        store.updateQuality();

        System.out.println("Day 2::" + '\n' + store.toString());
        store.updateQuality();

        System.out.println("Day 3::" + '\n' + store.toString());
        store.updateQuality();

    }

}
