import items.Item;

abstract public class Product {
    public static final int MAX_QUALITY = 50;
    protected Item item;

    public Product(Item item) {

        if(item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }

        this.item = item;
    }

    public void decrementDaysToExpire(int value) {
        item.sellIn = item.sellIn - value;
    }

    public boolean isExpired()
    {
        return item.sellIn == 0;
    }

    abstract void update();
}
