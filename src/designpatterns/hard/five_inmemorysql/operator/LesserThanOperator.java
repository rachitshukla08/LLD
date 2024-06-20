package designpatterns.hard.five_inmemorysql.operator;

public class LesserThanOperator implements Operator{

    @Override
    public boolean operate(String currVal, String expectedVal) {
        try {
            double val1 = Double.parseDouble(currVal);
            double val2 = Double.parseDouble(expectedVal);
            return val1 < val2;
        }
        catch (Exception e){
            System.out.println("Operands are not numbers");
            return currVal.compareTo(expectedVal) < 0;
        }
    }
}