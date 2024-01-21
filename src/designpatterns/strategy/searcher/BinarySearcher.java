package designpatterns.strategy.searcher;

import java.util.List;

public class BinarySearcher implements Searcher{
    @Override
    public int search(int key, List<Integer> nums) {
        int l=0; int h=nums.size()-1;
        while(l<=h){
            int m = (l+h)/2;
            if(nums.get(m) == key)
                return m;
            else if(nums.get(m)>key)
                h = m-1;
            else
                l = m+1;
        }
        return -1;
    }
}
