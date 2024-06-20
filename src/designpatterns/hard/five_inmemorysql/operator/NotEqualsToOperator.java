package designpatterns.hard.five_inmemorysql.operator;

public class NotEqualsToOperator implements Operator{
    @Override
    public boolean operate(String currVal, String expectedVal) {
        return (!currVal.equals(expectedVal));
    }
}
