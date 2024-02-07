package designpatterns.decorator;

public abstract class Topping extends Pizza{
    private final Pizza pizza;

    protected Topping(String name, double price, Pizza pizza) {
        super(name, price);
        this.pizza = pizza;
    }

    @Override
    public String getName(){
        return super.getName() + " " + pizza.getName();
    }

    @Override
    public double getCost(){
        return super.getCost() + pizza.getCost();
    }
}
