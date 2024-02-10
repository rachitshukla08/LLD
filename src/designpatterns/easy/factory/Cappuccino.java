package designpatterns.easy.factory;

public class Cappuccino extends Coffee {
    public Cappuccino(IngredientsFactory ingredientsFactory) {
        super(ingredientsFactory);
    }

    @Override
    public void brew() {
        System.out.println("Brewing cappuccino");
    }

    @Override
    public void boil() {
        System.out.println("Boiling Cappuccino");

    }
}
