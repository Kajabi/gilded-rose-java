package com.kajabi.gildedrose;

public class GildedRose {
  private String name;
  private int daysRemaining;
  private int quality;

  public GildedRose(String name, int daysRemaining, int quality) {
    this.name = name;
    this.daysRemaining = daysRemaining;
    this.quality = quality;
  }

  public String getName() {
    return name;
  }

  public int getDaysRemaining() {
      return daysRemaining;
  }

  public int getQuality() {
      return quality;
  }

  public void tick() {
    if (!this.name.equals("Aged Brie") && !this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (this.quality > 0) {
        if (!this.name.equals("Legendary Sulfuras, Hand of Ragnaros")) {
          this.quality--;
        }
      }
    } else {
      if (this.quality < 50) {
        this.quality++;
        if (this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (this.daysRemaining < 11) {
            if (this.quality < 50) {
              this.quality++;
            }
          }
          if (this.daysRemaining < 6) {
            if (this.quality < 50) {
              this.quality++;
            }
          }
        }
      }
    }
    if (!this.name.equals("Legendary Sulfuras, Hand of Ragnaros")) {
      this.daysRemaining--;
    }
    if (this.daysRemaining < 0) {
      if (!this.name.equals("Aged Brie")) {
        if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (this.quality > 0) {
            if (!this.name.equals("Legendary Sulfuras, Hand of Ragnaros")) {
              this.quality--;
            }
          }
        } else {
          this.quality = this.quality - this.quality;
        }
      } else {
        if (this.quality < 50) {
          this.quality++;
        }
      }
    }
  }
}