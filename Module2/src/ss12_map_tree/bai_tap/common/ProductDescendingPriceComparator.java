package ss12_map_tree.bai_tap.common;

import ss12_map_tree.bai_tap.entity.Product;

import java.util.Comparator;

public class ProductDescendingPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
}
