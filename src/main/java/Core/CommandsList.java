package Core;

import java.util.HashSet;

public class CommandsList {

    private HashSet<Command> commandHashSet = new HashSet<>();

    public CommandsList(){

    }

    public void addCommand(Command command){
        commandHashSet.add(command);
    }

    public HashSet<Command> getCommandHashSet() {
        return commandHashSet;
    }
}
