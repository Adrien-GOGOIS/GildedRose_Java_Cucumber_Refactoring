Feature: Gilded Rose quality
  I want to know if the sellIn and the quality is updated properly

  Scenario Outline: Checking updating sellIn -1 and quality -1 of an normal item
    Given The "<item>" is sellIn <sellIn> and quality <quality>
    When I update the sellIn and the quality of 1 day
    Then I should get item sellIn <expectedSellIn> and quality <expectedQuality>

    Examples:
      | item                                      | sellIn | quality  | expectedSellIn | expectedQuality |
      | +5 Dexterity Vest                         | 10     | 5        | 9               | 4              |
      | +5 Dexterity Vest                         | 1      | 10       | 0               | 9              |
      | Elixir of the Mongoose                    | 5      | 0        | 4               | 0              |
      | Elixir of the Mongoose                    | 9      | 5        | 8               | 4              |


  Scenario Outline: Checking updating sellIn -1 and quality +1 of an Aged Brie
    Given The "<item>" is sellIn <sellIn> and quality <quality>
    When I update the sellIn and the quality of 1 day
    Then I should get item sellIn <expectedSellIn> and quality <expectedQuality>

    Examples:
      | item                                      | sellIn | quality  | expectedSellIn | expectedQuality |
      | Aged Brie                                 | 1      | 0        | 0               | 1              |
      | Aged Brie                                 | 5      | 2        | 4               | 3              |


  Scenario Outline: Checking updating sellIn +-0 and quality +-0 of Sulfuras
    Given The "<item>" is sellIn <sellIn> and quality <quality>
    When I update the sellIn and the quality of 1 day
    Then I should get item sellIn <expectedSellIn> and quality <expectedQuality>

    Examples:
      | item                                      | sellIn | quality  | expectedSellIn | expectedQuality |
      | Sulfuras, Hand of Ragnaros                | 0      | 80       | 0               | 80             |
      | Sulfuras, Hand of Ragnaros                | 9      | 80       | 9               | 80             |


  Scenario Outline: Checking updating sellIn -1 and quality  +2 / +3 / 0 of Backstage passes to a TAFKAL80ETC concert
    Given The "<item>" is sellIn <sellIn> and quality <quality>
    When I update the sellIn and the quality of 1 day
    Then I should get item sellIn <expectedSellIn> and quality <expectedQuality>

    Examples:
      | item                                      | sellIn | quality  | expectedSellIn | expectedQuality |
      | Backstage passes to a TAFKAL80ETC concert | 10     | 20       | 9              | 22              |
      | Backstage passes to a TAFKAL80ETC concert | 5      | 20       | 4              | 23              |
      | Backstage passes to a TAFKAL80ETC concert | -1     | 20       | -2             | 0               |


  Scenario Outline: Checking updating sellIn -1 and quality -2 of Conjured Items
    Given The "<item>" is sellIn <sellIn> and quality <quality>
    When I update the sellIn and the quality of 1 day
    Then I should get item sellIn <expectedSellIn> and quality <expectedQuality>

    Examples:
      | item                                      | sellIn | quality  | expectedSellIn | expectedQuality |
      | Conjured Mana Cake                        | 10     | 5        | 9              | 3              |
      | Conjured Mana Cake                        | 1      | 10       | 0              | 8              |