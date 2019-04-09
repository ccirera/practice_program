import items.Item;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private List<Product> products;

    public GildedRose(){
        products = new ArrayList<>();
    }

    public void addItem(Item item) {
        products.add(ProductFactory.create(item)) ;
    }

    public void updateInventory() {

        Product product = products.get(0) ;

        product.update();
    }
}
