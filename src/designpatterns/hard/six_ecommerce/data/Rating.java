package designpatterns.hard.six_ecommerce.data;

public enum Rating {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);
    private final int val;
    private Rating(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }
}
