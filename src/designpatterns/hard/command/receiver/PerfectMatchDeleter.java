package designpatterns.hard.command.receiver;

import designpatterns.hard.command.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {
    public void delete(String name) {
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach(tag -> tags.add(tag));
        for(String tag: tags){
            if(name.equals(tag)){
                Store.delete(tag);
            }
        }
    }
}

