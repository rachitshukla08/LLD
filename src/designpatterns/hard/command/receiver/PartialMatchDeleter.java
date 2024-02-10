package designpatterns.hard.command.receiver;

import designpatterns.hard.command.data.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleter {
    public void delete(Pattern pattern){
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach(tag -> tags.add(tag));
        for(String tag: tags){
            if(pattern.matcher(tag).matches()) {
                Store.delete(tag);
            }
        }
    }
}
