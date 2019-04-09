import items.Item;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {

    @Test
    public void shouldDecreaseQualityAndValue() {
        GildedRose gildedRose = new GildedRose();
        Item newItem = new Item("New Item", 10, 3);
        gildedRose.addItem(newItem);

        gildedRose.updateInventory();

        assertThat(newItem.sellIn, is(9));
        assertThat(newItem.quality, is(2));
    }

    @Test
    public void shouldDecreaseTwiceAsFastWhenSellDateHasPassed() {
        GildedRose gildedRose = new GildedRose();
        Item newItem = new Item("New Item", 0, 3);
        gildedRose.addItem(newItem);

        gildedRose.updateInventory();

        assertThat(newItem.sellIn, is(0));
        assertThat(newItem.quality, is(1));
    }

    @Test
    public void shouldNeverHaveNegativeQuality() {
        GildedRose gildedRose = new GildedRose();
        Item newItem = new Item("New Item", 1, 0);
        gildedRose.addItem(newItem);

        gildedRose.updateInventory();

        assertThat(newItem.sellIn, is(0));
        assertThat(newItem.quality, is(0));
    }

    @Test
    public void agedBrieShouldIncreaseItsQualityTheOlderItGets() {
        GildedRose gildedRose = new GildedRose();
        Item agedBrie = new Item("Aged Brie", 10, 3);
        gildedRose.addItem(agedBrie);

        gildedRose.updateInventory();

        assertThat(agedBrie.sellIn, is(9));
        assertThat(agedBrie.quality, is(4));
    }

    @Test
    public void sulfurasShouldNeverChangeItsQualityAndSellInValues() {
        GildedRose gildedRose = new GildedRose();
        Item sulfuras = new Item("Sulfuras", 100, 80);
        gildedRose.addItem(sulfuras);

        gildedRose.updateInventory();

        assertThat(sulfuras.sellIn, is(100));
        assertThat(sulfuras.quality, is(80));
    }

    @Test
    public void shouldHasAQualityHigherThanMaxQuality() {
        GildedRose gildedRose = new GildedRose();
        Item item = new Item("Item", 10, 100);
        gildedRose.addItem(item);

        assertThat(item.sellIn, is(10));
        assertThat(item.quality, is(50));
    }


    @Test
    public void sulfurasShouldAlwaysHasLegendaryQuality() {
        GildedRose gildedRose = new GildedRose();
        Item item = new Item("Sulfuras", 10, 100);
        gildedRose.addItem(item);

        assertThat(item.sellIn, is(10));
        assertThat(item.quality, is(80));
    }
}
