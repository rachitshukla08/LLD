package designpatterns.strategy.inserter;

import java.util.List;

public class UnorderedInserter implements Inserter{
    @Override
    public void insert(int num, List<Integer> nums) {
        nums.add(num);
        System.out.println("UnorderedInsert successful");
    }
}
