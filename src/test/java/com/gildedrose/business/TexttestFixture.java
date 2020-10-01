package com.gildedrose.business;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TexttestFixture {
    @Test
    @DisplayName("inital test from scratch")
    public void initialTest() throws InvalidInputException {
        System.out.println("OMGHAI!");

        List<QualityControl> items = List.of(new ItemBuilder("+5 Dexterity Vest", 10, 20),
                new AgedBrie( 2, 0),
                new ItemBuilder("Elixir of the Mongoose", 5, 7),
                new Sulfuras( 0, 80),
                new Sulfuras( -1, 80),
                new BackStage(15, 20),
                new BackStage( 10, 49),
                new BackStage(5, 49));
        // new Conjured("Conjured Mana Cake", 3, 6) ;
        ///next step add Conjured class
        GildedRose app = new GildedRose();

        int days = 2;
        String[] args = {};
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }
        for (int i = 0; i <= days; i++) {
            System.out.println("-------- day " + i + " --------");

            System.out.println("name, sellIn, quality");
            for(QualityControl item : items) {
                app.addItem(item);
                System.out.println(item);
            }
            app.updateQuality();
            System.out.println();
        }

    }
}

