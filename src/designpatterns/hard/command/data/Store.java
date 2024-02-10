package designpatterns.hard.command.data;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<String> tags = new ArrayList<>(){
        {
            add("knapsack");
            add("math");
            add("mathematics");
            add("sieve");
            add("runtime error");
        }
    };

    public static List<String> getTags() {
        return tags;
    }

    public static void delete(String tag){
        tags.remove(tag);
        System.out.println(tag + " removed");
    }

    public static void insert(String tag){
        tags.add(tag);
        System.out.println(tag + " added");
    }
}
