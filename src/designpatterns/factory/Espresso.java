package designpatterns.factory;

public class Espresso extends Coffee{
    public Espresso(IngredientsFactory ingredients) {
        super(ingredients);
    }

    @Override
    public void brew() {
        System.out.println("Brewing espresso");
    }

    @Override
    public void boil() {
        System.out.println("Boiling espresso");
    }
}
