package designpatterns.decorator;

import designpatterns.decorator.base.ThinCrust;
import designpatterns.decorator.base.WheatBase;
import designpatterns.decorator.topping.Olive;
import designpatterns.decorator.topping.Onion;

public class Tester {
    public static void main(String[] args) {
        Pizza p = new Onion(new Olive(new WheatBase()));
        System.out.println(p.getCost());
        System.out.println(p.getName());
    }
}
