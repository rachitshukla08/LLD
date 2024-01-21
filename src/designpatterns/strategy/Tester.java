package designpatterns.strategy;

import designpatterns.strategy.inserter.OrderedInserter;
import designpatterns.strategy.inserter.UnorderedInserter;
import designpatterns.strategy.searcher.BinarySearcher;

public class Tester {
    public static void main(String[] args) {
        NumberStore numberStore = new NumberStore(new OrderedInserter(), new BinarySearcher());
        numberStore.insert(1);
        numberStore.insert(0);
        numberStore.insert(10);
        numberStore.insert(2);
        System.out.println(numberStore.search(10));
        System.out.println(numberStore.search(0));
        System.out.println(numberStore.search(1));
    }

}
