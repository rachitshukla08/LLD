package designpatterns.easy.factory;

public interface IngredientsFactory {
    public Bean getBean();
    public Sugar getSugar();
    public Milk getMilk();
}
