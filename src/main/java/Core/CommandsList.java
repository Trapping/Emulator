package Core;

import java.util.ArrayList;

public class CommandsList {

    private ArrayList<Command> commandArrayList = new ArrayList<>();

    public CommandsList(){
    }

    public void addCommand(Command command){
        commandArrayList.add(command);
    }

    public ArrayList<Command> getCommandArrayList() {
        return commandArrayList;
    }

    public ArrayList<String> getCodesArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Command command: commandArrayList
             ) {
            arrayList.add(command.getCode());
        }
        return arrayList;
    }
}
