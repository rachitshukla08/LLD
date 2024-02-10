package designpatterns.hard.command.factory;

import designpatterns.hard.command.cmd.Command;
import designpatterns.hard.command.cmd.PartialMatchDeleteCommand;
import designpatterns.hard.command.cmd.PerfectMatchDeleteCommand;
import designpatterns.hard.command.receiver.PartialMatchDeleter;
import designpatterns.hard.command.receiver.PerfectMatchDeleter;

import java.util.regex.Pattern;

public class CommandFactory {
    private CommandFactory(){}

    public static Command getPartialMatchDeleteCommand(Pattern pattern, PartialMatchDeleter partialMatchDeleter) {
        return new PartialMatchDeleteCommand(pattern, partialMatchDeleter);
    }

    public static Command getPerfectMatchDeleteCommand(String name, PerfectMatchDeleter perfectMatchDeleter){
        return new PerfectMatchDeleteCommand(name, perfectMatchDeleter);
    }
}
