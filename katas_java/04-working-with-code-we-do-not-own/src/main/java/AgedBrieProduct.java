import items.Item;

public class AgedBrieProduct extends Product {

    public AgedBrieProduct(Item item) {
        super(item);
    }

    private void increaseQuality(int value) {
        item.quality = item.quality + value;
    }

    @Override
    public void update() {
        if(isExpired()) {
            increaseQuality(2);
            return;
        }

        decrementDaysToExpire(1);
        increaseQuality(1);
    }
}
