package designpatterns.hard.command.cmd;

import designpatterns.hard.command.receiver.PartialMatchDeleter;

import java.util.regex.Pattern;

public class PartialMatchDeleteCommand implements Command{
    private final Pattern regex;
    private final PartialMatchDeleter partialMatchDeleter;

    public PartialMatchDeleteCommand(Pattern regex, PartialMatchDeleter partialMatchDeleter) {
        this.regex = regex;
        this.partialMatchDeleter = partialMatchDeleter;
    }

    @Override
    public void execute() {
        partialMatchDeleter.delete(this.regex);
    }
}
