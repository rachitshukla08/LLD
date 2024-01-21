package designpatterns.strategy;

import designpatterns.strategy.inserter.Inserter;
import designpatterns.strategy.searcher.Searcher;

import java.util.ArrayList;
import java.util.List;

public class NumberStore {
    private final List<Integer> nums;
    private final Inserter inserter;
    private final Searcher searcher;

    public NumberStore(Inserter inserter, Searcher searcher) {
        this.nums = new ArrayList<>();
        this.inserter = inserter;
        this.searcher = searcher;
    }

    public void insert(int num){
        this.inserter.insert(num, this.nums);
    }

    public int search(int key){
        return this.searcher.search(key, this.nums);
    }
}
