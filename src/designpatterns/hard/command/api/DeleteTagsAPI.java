package designpatterns.hard.command.api;

import designpatterns.hard.command.TagManager;
import designpatterns.hard.command.cmd.Command;
import designpatterns.hard.command.cmd.MatchType;
import designpatterns.hard.command.factory.CommandFactory;
import designpatterns.hard.command.receiver.PartialMatchDeleter;
import designpatterns.hard.command.receiver.PerfectMatchDeleter;

import java.util.regex.Pattern;

public class DeleteTagsAPI {
    public void deleteTags(String name, MatchType matchType){
        Command command= null;
        if(matchType.equals(MatchType.PERFECT)){
            command = CommandFactory.getPerfectMatchDeleteCommand(name, new PerfectMatchDeleter());
        }
        else if(matchType.equals(MatchType.PARTIAL)){
            command = CommandFactory.getPartialMatchDeleteCommand(Pattern.compile(name), new PartialMatchDeleter());
        }
        else {
            throw new IllegalArgumentException("Invalid matchtype");
        }
        new TagManager(command).changeTags();
    }
}
