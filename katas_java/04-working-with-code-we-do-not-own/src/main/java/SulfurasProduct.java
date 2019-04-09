import items.Item;

public class SulfurasProduct extends Product {

    public static final int LEGENDARY_QUALITY = 80;

    public SulfurasProduct(Item item) {
        super(item);

        item.quality = LEGENDARY_QUALITY;
    }

    @Override
    public void update() {
    }
}
