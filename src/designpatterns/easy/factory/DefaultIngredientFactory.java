package designpatterns.easy.factory;

public class DefaultIngredientFactory implements IngredientsFactory {
    @Override
    public Bean getBean() {
        return new AmericanBean();
    }

    @Override
    public Sugar getSugar() {
        return new RegularSugar();
    }

    @Override
    public Milk getMilk() {
        return new PowderedMilk();
    }
}
