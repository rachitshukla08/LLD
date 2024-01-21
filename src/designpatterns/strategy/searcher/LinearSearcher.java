package designpatterns.strategy.searcher;

import java.util.List;

public class LinearSearcher implements Searcher{
    @Override
    public int search(int key, List<Integer> nums) {
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i)==key)
                return i;
        }
        return -1;
    }
}
