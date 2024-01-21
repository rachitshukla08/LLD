package designpatterns.factory;

public abstract class Coffee {
    private final Bean bean;
    private final Sugar sugar;
    private final Milk milk;
    private final IngredientsFactory ingredientsFactory;

    protected Coffee(IngredientsFactory ingredientsFactory) {
        this.ingredientsFactory = ingredientsFactory;
        this.bean = ingredientsFactory.getBean();
        this.sugar = ingredientsFactory.getSugar();
        this.milk = ingredientsFactory.getMilk();
    }

    abstract void brew();
    abstract void boil();
}
