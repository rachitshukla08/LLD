package designpatterns.strategy.inserter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrderedInserter implements Inserter{
    @Override
    public void insert(int num, List<Integer> nums) {
        nums.add(num);
        int k = nums.size() - 1;
        while(k>0 && nums.get(k) < nums.get(k-1)){
            Collections.swap(nums, k-1, k);
            k--;
        }
        System.out.println("OrderedInsert successful");
    }
}
