package com.gildedrose.ui;

import com.gildedrose.business.*;

import java.util.List;

public class ProductListApp {
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("OMGHAI!");

        GildedRose store = new GildedRose();

        List<QualityControl> items =List.of(new ItemBuilder("+5 Dexterity Vest", 10, 20),
                new AgedBrie( 2, 0),
                new ItemBuilder("Elixir of the Mongoose", 5, 7),
                new Sulfuras( 0, 80),
                new Sulfuras(-1, 80),
                new BackStage( 15, 20),
                new BackStage( 10, 49),
                new BackStage(5, 49));

        for (QualityControl item : items) {
            store.addItem(item);
        }
        //Display the inventory list
        System.out.println("\t -------- day 1 --------");
        System.out.println(store.toString());

        // One day is gone, inventory updated, display list
        store.updateQuality();

        //after update display update inventory
        System.out.println("\t -------- day 2 --------");
        System.out.println(store.toString());


        //Another day is gone, inventory updated, display list
        store.updateQuality();
        System.out.println("\t -------- day 3 --------");
        System.out.println(store.toString());
    }
}
/*
@startuml
package com{
package gildedrose{
package ui #LightGrey{
class ProductListApp{
    + {static} main(args : String[]) : void
}
}
package business #Lavender{
class AgedBrie{
    - {static} name : {readOnly}
    + updateQuality() : void
    + AgeBrie(sellIn : int, quality : int)

}
class BackStage{
    - {static} name : {readOnly}
    + updateQuality() : void
    + BackStage(sellIn : int, quality : int)
}
class Sulfuras{
    - {static} name : {readOnly}
    + updateQuality() : void
    + Sulfuras(sellIn : int, quality : int)
}
class Conjured{
    - {static} name : {readOnly}
    + updateQuality() : void
    + Conjured(sellIn : int, quality : int)
}
class Item{
    + quality : int
    + sellIn : String
    + name : String
    + toString() String
    + Item(name : String, sellIn : int, quality : int)
}
class ItemBuilder{
    + toString() : String
    + qualityCalculation(value : int) : void
    + updateQuality() : void
    # setQuality(value : int) : void
    # getQuality() : int
    # SetSellIn() : void
    # getSellIn() : int
    # getName() : String
    + ItemBuilder(name : String, sellIn : int, quantity : int)
}

interface QualityControl{
      MAX_QUALITY : inT
      MINIMUM_QUALITY : int
      MAX_QUALITY_LEGENDARY : int
      SELL_IN_LEGENDARY : int
    + {abstract} qualityCalculation(value : int) : void
    + {abstract} updateQuality() : void

}
class GildedRose{
    - inventoryList : List<QualityControl>
    + toString() : String
    + updateQuality() : void
    + addItem(item : QualityControl) :  void
    + inventoryList() : List<QualityControl>
}
class InvalidInputException {
     + InvalidInputException(message : String)

}

package Test #OldLace{
class AgedBrieTest #Azure{
    + qualityMax50() : void
    + updateQualityBrieExpired() : void
    + updateQualityBrie() : void
    + agedBrieGenerator() : void
}
class BackStageTest #Azure{
    + qualityBackStageMax50() : void
    + updateQualityBackStageExpired() : void
    + updateQualityOverZero() : void
    + updateQualityOverFive() : void
    + updateQualityOverTen() : void
    + toStringTest() : void
    + backStageGenerator() : void
}

class SulfurasTest #Azure{
    + updateQualitySulfuras() :  void
    + toStringTest() : void
    + sulfurasGenerator() : void

}
class GildedRoseTest #Azure{
    - agedBrie : AgedBrie
    - normalItem : NormalItem
    - store : GildedRose
    + updateQuality() : void
    + addItemTest() : void
    + toStringTest() : void
    + setupStorage() : void
}
class ItemTest #Azure{
 + itemGenerator() : void
}
class QualityControlTest #Azure{
    + qualityMinimumZero() : void
    + updateQualityItemBuilderExpired() : void
    + updateQualityItemBuilder() :void
    + toStringTest() : void
    + itemBuilderGenerator() : void
}
class TexttesFixture #Azure{
    + initialTest() : void
}
package businness{
class InheritanceTest #Azure{
     + updateQuality() : void
     + gildedRoseAddItem() : void
     + updateQualityBrie() : void
     + generateAgedBrie() : void
     + qualityNormalItemMinimZero() : void
     + updateQualityNormalItemExpired() : void
     + updateQualityNormalItem() : void
     + toStringTest() : void
}
}
}
}
}
}
package java{
package lang #DDDDDD{
class Exception{
  + Exception(message : String)
}
}
}
Item <|--- "is-a" ItemBuilder
QualityControl <|... ItemBuilder
ItemBuilder <|-- "is-a" AgedBrie
ItemBuilder <|-- "is-a" BackStage
ItemBuilder <|-- "is-a" Sulfuras
ItemBuilder <|-- "is-a" Conjured
Exception <|-- "is-a"InvalidInputException
QualityControl ---* "has-a" GildedRose : link
note on link #Khaki: java.util.List<b><E></b> \njava.util.List<b><com.gilderdrose.business.QualityControl</b>>
AgedBrie --* ProductListApp #Blue
BackStage --* ProductListApp #Blue
Sulfuras --* "has-a" ProductListApp #Blue
QualityControl -* ProductListApp #Blue
GildedRose -----* "has-a" GildedRoseTest #DarkGrey
AgedBrie -----* "has-a" GildedRoseTest #DarkGrey
ItemBuilder -----* "has-a" GildedRoseTest #DarkGrey
@enduml
*/