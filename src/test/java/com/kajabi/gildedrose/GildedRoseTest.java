package com.kajabi.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.opentest4j.AssertionFailedError;

public class GildedRoseTest {
  @Test
  void normalItemBeforeSellDate() {
    GildedRose rose = new GildedRose("Normal Item", 5, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 9);
  }

  @Test
  void normalItemOnSellDate() {
    GildedRose rose = new GildedRose("Normal Item", 0, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 8);
  }

  @Test
  void normalItemAfterSellDate() {
    GildedRose rose = new GildedRose("Normal Item", -10, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -11, 8);
  }

  @Test
  void normalItemOfZeroQuality() {
    GildedRose rose = new GildedRose("Normal Item", 5, 0);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 0);
  }

  @Test
  void agedBrieBeforeSellDate() {
    GildedRose rose = new GildedRose("Aged Brie", 5, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 11);
  }

  @Test
  void agedBrieWithMaxQuality() {
    GildedRose rose = new GildedRose("Aged Brie", 5, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 50);
  }

  @Test
  void agedBrieOnSellDate() {
    GildedRose rose = new GildedRose("Aged Brie", 0, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 12);
  }

  @Test
  void agedBrieOnSellDateNearMaxQuality() {
    GildedRose rose = new GildedRose("Aged Brie", 0, 49);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 50);
  }

  @Test
  void agedBrieOnSellDateWithMaxQuality() {
    GildedRose rose = new GildedRose("Aged Brie", 0, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 50);
  }

  @Test
  void agedBrieAfterSellDate() {
    GildedRose rose = new GildedRose("Aged Brie", -10, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -11, 12);
  }

  @Test
  void agedBrieAfterSellDateWithMaxQuality() {
    GildedRose rose = new GildedRose("Aged Brie", -10, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -11, 50);
  }

  @Test
  void sulfurasBeforeSellDate() {
    GildedRose rose = new GildedRose("Legendary Sulfuras, Hand of Ragnaros", 5, 80);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 5, 80);
  }

  @Test
  void sulfurasOnSellDate() {
    GildedRose rose = new GildedRose("Legendary Sulfuras, Hand of Ragnaros", 0, 80);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 0, 80);
  }

  @Test
  void sulfurasAfterSellDate() {
    GildedRose rose = new GildedRose("Legendary Sulfuras, Hand of Ragnaros", -10, 80);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -10, 80);
  }

  @Test
  void backstagePassLongBeforeSellDate() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 11, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 10, 11);
  }

  @Test
  void backstagePassLongBeforeSellDateAtMaxQuality() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 11, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 10, 50);
  }

  @Test
  void backstagePassMediumCloseToSellDateUpperBound() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 9, 12);
  }

  @Test
  void backstagePassMediumCloseToSellDateUpperBoundAtMaxQuality() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 9, 50);
  }

  @Test
  void backstagePassMediumCloseToSellDateLowerBound() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 6, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 5, 12);
  }

  @Test
  void backstagePassMediumCloseToSellDateLowerBoundAtMaxQuality() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 6, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 5, 50);
  }

  @Test
  void backstagePassVeryCloseToSellDateUpperBound() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 13);
  }

  @Test
  void backstagePassVeryCloseToSellDateUpperBoundAtMaxQuality() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 50);
  }

  @Test
  void backstagePassVeryCloseToSellDateLowerBound() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 1, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 0, 13);
  }

  @Test
  void backstagePassVeryCloseToSellDateLowerBoundAtMaxQuality() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 1, 50);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 0, 50);
  }

  @Test
  void backstagePassOnSellDate() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 0);
  }

  @Test
  void backstagePassAfterSellDate() {
    GildedRose rose = new GildedRose("Backstage passes to a TAFKAL80ETC concert", -10, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -11, 0);
  }

  @Disabled
  @Test
  void conjuredManaBeforeSellDate() {
    GildedRose rose = new GildedRose("Conjured Mana Cake", 5, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 8);
  }

  @Disabled
  @Test
  void conjuredManaBeforeSellDateAtZeroQuality() {
    GildedRose rose = new GildedRose("Conjured Mana Cake", 5, 0);

    rose.tick();

    assertDaysRemainingAndQuality(rose, 4, 0);
  }

  @Disabled
  @Test
  void conjuredManaOnSellDate() {
    GildedRose rose = new GildedRose("Conjured Mana Cake", 0, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 6);
  }

  @Disabled
  @Test
  void conjuredManaOnSellDateAtZeroQuality() {
    GildedRose rose = new GildedRose("Conjured Mana Cake", 0, 0);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -1, 0);
  }

  @Disabled
  @Test
  void conjuredManaAfterSellDate() {
    GildedRose rose = new GildedRose("Conjured Mana Cake", -10, 10);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -11, 6);
  }

  @Disabled
  @Test
  void conjuredManaAfterSellDateAtZeroQuality() {
    GildedRose rose = new GildedRose("Conjured Mana Cake", -10, 0);

    rose.tick();

    assertDaysRemainingAndQuality(rose, -11, 0);
  }

  /**
   * Assertion helper to simplify test cases.
   * 
   * @param rose          The object under test. Its getDaysRemaining and
   *                      getQuality will be compared.
   * @param daysRemaining The expected daysRemaining to compare.
   * @param quality       The expected quality to compare.
   */
  private void assertDaysRemainingAndQuality(GildedRose rose, int daysRemaining, int quality) {
    StringBuilder errorBuilder = new StringBuilder();

    boolean daysRemainingError = daysRemaining != rose.getDaysRemaining();
    if (daysRemainingError) {
      errorBuilder.append("Expected daysRemaining <").append(daysRemaining).append("> but was <")
          .append(rose.getDaysRemaining()).append(">.");
    }

    boolean qualityError = quality != rose.getQuality();
    if (qualityError) {
      if (daysRemainingError) {
        errorBuilder.append(" ");
      }
      errorBuilder.append("Expected quality <").append(quality).append("> but was <").append(rose.getQuality())
          .append(">.");
    }

    if (qualityError || daysRemainingError) {
      throw new AssertionFailedError(errorBuilder.toString());
    }
  }
}
