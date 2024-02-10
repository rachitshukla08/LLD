package designpatterns.hard.command;

import designpatterns.hard.command.api.DeleteTagsAPI;
import designpatterns.hard.command.cmd.MatchType;

public class Tester {
    public static void main(String[] args) {
        new DeleteTagsAPI().deleteTags("math.*", MatchType.PARTIAL);
    }
}
