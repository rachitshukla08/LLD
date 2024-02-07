package designpatterns.decorator.topping;

import designpatterns.decorator.Pizza;
import designpatterns.decorator.Topping;

public class Onion extends Topping {
    public Onion(Pizza pizza) {
        super("Onion", 10, pizza);
    }
}
