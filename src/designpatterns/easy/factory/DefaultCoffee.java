package designpatterns.easy.factory;

public class DefaultCoffee extends Coffee {
    protected DefaultCoffee(IngredientsFactory ingredientsFactory) {
        super(ingredientsFactory);
    }

    @Override
    void brew() {

    }

    @Override
    void boil() {

    }
}
