package designpatterns.easy.factory;

public class EspressoIngredientsFactory implements IngredientsFactory {

    @Override
    public Bean getBean() {
        return new FrenchBean();
    }

    @Override
    public Sugar getSugar() {
        return new BrownSugar();
    }

    @Override
    public Milk getMilk() {
        return new PowderedMilk();
    }
}
