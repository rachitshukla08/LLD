package designpatterns.decorator.topping;

import designpatterns.decorator.Pizza;
import designpatterns.decorator.Topping;

public class Olive extends Topping {
    public Olive(Pizza pizza) {
        super("Olive", 5, pizza);
    }
}
