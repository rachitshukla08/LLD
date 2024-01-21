package designpatterns.factory;

public class Robusta extends Coffee{
    public Robusta(IngredientsFactory ingredientsFactory) {
        super(ingredientsFactory);
    }

    @Override
    public void brew() {
        System.out.println("Brewing robusta");
    }

    @Override
    public void boil() {
        System.out.println("Boiling robusta");
    }
}
