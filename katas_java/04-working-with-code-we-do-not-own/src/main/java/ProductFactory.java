import items.Item;

public class ProductFactory {
    public static Product create(Item item) {
        if(item.name.equals("Aged Brie")) {
            return new AgedBrieProduct(item);
        }

        if(item.name.equals("Sulfuras")) {
            return new SulfurasProduct(item);
        }

        return new RegularProduct(item);
    }
}
