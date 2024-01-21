package designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class NumberStoreUnoptimised {
    private final List<Integer> nums;
    private final InsertStrategyUnoptimised insertStrategy;
    private  final SearchStrategyUnoptimised searchStrategy;

    public NumberStoreUnoptimised(InsertStrategyUnoptimised insertStrategy, SearchStrategyUnoptimised searchStrategy) {
        this.nums = new ArrayList<>();
        this.insertStrategy = insertStrategy;
        this.searchStrategy = searchStrategy;
    }

    public void insert(int num){
        if(this.insertStrategy.equals(InsertStrategyUnoptimised.UNORDERED)) {
            orderedInsert(num);
        } else {
            unorderedInsert(num);
        }
    }

    public int search(int key){
        if(searchStrategy.equals(SearchStrategyUnoptimised.LINEAR)) {
            linearSearch(key);
        } else {
            binarySearch(key);
        }
        return 0;
    }

    private void orderedInsert(int num){}

    private void unorderedInsert(int num){
        this.nums.add(num);
    }

    private int linearSearch(int key) {
        return 0;
    }

    private int binarySearch(int key){
        return 0;
    }
}
