package by.tc.library.controller.command;

import by.tc.library.controller.command.impl.*;

import java.util.HashMap;

public class CommandProvider {
    private HashMap<CommandName,Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(CommandName.LOADFIRSTPAGE,new LoadFirstPage());
        commands.put(CommandName.LOADREGPAGE,new LoadRegistrationPage());
        commands.put(CommandName.REGISTRATION,new Registration());
        commands.put(CommandName.LOADAUTHPAGE,new LoadAuthPage());
        commands.put(CommandName.AUTHORIZATION, new Authorization());
        commands.put(CommandName.LOADMAINPAGE,new LoadMainPage());
        commands.put(CommandName.LOGOUT,new LogOut());
        commands.put(CommandName.CHANGELOCALE,new ChangeLocale());
        commands.put(CommandName.LOADADDINGBOOKPAGE,new LoadAddingBookPage());
        commands.put(CommandName.LOADCATALOGPAGE,new LoadCatalogPage());
        commands.put(CommandName.SHOWBOOKS,new ShowBooks());
    }
    public Command takeCommand(String name){
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }
}
