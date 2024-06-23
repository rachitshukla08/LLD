package designpatterns.hard.six_ecommerce.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {
    private final int id;
    private final List<ProductCopy> products;

    public Cart(int id, List<ProductCopy> products) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public void addProductCopy(ProductCopy productCopy){
        // some more checks
        this.products.add(productCopy);
    }

    public void removeProductCopy(ProductCopy productCopy) {
        if(!this.products.contains(productCopy))
            throw new RuntimeException("Product not in cart");
        this.products.remove(productCopy);
    }

    public double getCartAmount(){
        double amount = 0;
        for(ProductCopy productCopy: this.products){
            amount += productCopy.getProduct().getPriceINR();
        }
        return amount;
    }

    public int getDistinctItemsCount() {
        Set<Integer> distinctIds = new HashSet<>();
        for(ProductCopy productCopy: this.products){
            distinctIds.add(productCopy.getProduct().getId());
        }
        return distinctIds.size();
    }

    public int getTotalItemsCount() {
        return this.products.size();
    }


}
