package designpatterns.factory;

public class CoffeeFactory implements AbstractFactory{
    public Coffee getCoffee(String coffeeType) {
        Coffee coffee;
        if(coffeeType.equals("Cappuccino"))
            coffee = new Cappuccino(new CappuccinoIngredientsFactory());
        else if(coffeeType.equals("Espresso"))
            coffee = new Espresso(new EspressoIngredientsFactory());
        else if(coffeeType.equals("Robusta"))
            coffee = new Robusta(new RobustaIngredientsFactory());
        else
            coffee = new DefaultCoffee(new DefaultIngredientFactory());
        return coffee;
    }
}
