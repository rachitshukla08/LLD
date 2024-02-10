package designpatterns.easy.factory;

public class CoffeeServer {
    public final AbstractFactory factory;

    public CoffeeServer(AbstractFactory factory) {
        this.factory = factory;
    }

    public Coffee serve(String coffeeType) {
        Coffee coffee = this.factory.getCoffee(coffeeType);
        coffee.boil();
        coffee.brew();
        return coffee;
    }
}
