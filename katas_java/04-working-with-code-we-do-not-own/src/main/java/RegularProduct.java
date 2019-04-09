import items.Item;

public class RegularProduct extends Product {

    private static final int MIN_QUALITY = 0;

    public RegularProduct(Item item) {
        super(item);
    }

    private void decreaseQuality(int value) {
        int quality = item.quality - value;
        if (quality >= MIN_QUALITY)
        {
            item.quality = quality;
        }
    }

    @Override
    public void update() {
        if(isExpired()) {
            decreaseQuality(2);
            return;
        }

        decrementDaysToExpire(1);
        decreaseQuality(1);
    }
}
