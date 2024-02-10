package designpatterns.hard.command;

import designpatterns.hard.command.cmd.Command;

public class TagManager {
   private final Command command;

    public TagManager(Command command) {
        this.command = command;
    }

    public void changeTags() {
        this.command.execute();
    }
}
