package designpatterns.strategy.searcher;

import java.util.List;

public interface Searcher {
    public int search(int key, List<Integer> nums);
}
