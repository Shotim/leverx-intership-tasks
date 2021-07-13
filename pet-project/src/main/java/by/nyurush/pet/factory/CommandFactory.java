package by.nyurush.pet.factory;

import by.nyurush.pet.controller.command.Command;
import by.nyurush.pet.controller.command.impl.pet.DeletePetCommand;
import by.nyurush.pet.controller.command.impl.pet.GetAllCatsCommand;
import by.nyurush.pet.controller.command.impl.pet.GetAllDogsCommand;
import by.nyurush.pet.controller.command.impl.pet.GetAllPetsCommand;
import by.nyurush.pet.controller.command.impl.pet.GetPetByIdCommand;
import by.nyurush.pet.controller.command.impl.pet.GetPetsByUserCommand;
import by.nyurush.pet.controller.command.impl.pet.SavePetCommand;
import by.nyurush.pet.controller.command.impl.user.DeleteUserCommand;
import by.nyurush.pet.controller.command.impl.user.GetAllUsersCommand;
import by.nyurush.pet.controller.command.impl.user.GetUserByIdCommand;
import by.nyurush.pet.controller.command.impl.user.SaveUserCommand;
import by.nyurush.pet.exception.CommandNotFoundException;
import by.nyurush.pet.util.StringConstants;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {

    }

    static {
        commands.put("get_users", new GetAllUsersCommand());
        commands.put("get_users/id", new GetUserByIdCommand());
        commands.put("get_users/id/pets", new GetPetsByUserCommand());

        commands.put("get_pets", new GetAllPetsCommand());
        commands.put("get_pets/id", new GetPetByIdCommand());
        commands.put("get_pets/cats", new GetAllCatsCommand());
        commands.put("get_pets/dogs", new GetAllDogsCommand());

        commands.put("post_users", new SaveUserCommand());
        commands.put("post_pets", new SavePetCommand());

        commands.put("put_users/id", new SaveUserCommand());
        commands.put("put_pets/id", new SavePetCommand());

        commands.put("delete_users/id", new DeleteUserCommand());
        commands.put("delete_pets/id", new DeletePetCommand());
    }

    public static Command getCommand(String commandName) {
        if (commandName.isBlank()
                || commandName.equals(StringConstants.GET)
                || commandName.equals(StringConstants.POST)
                || commandName.equals(StringConstants.PUT)
                || commandName.equals(StringConstants.DELETE)) {

            throw new CommandNotFoundException("Command " + commandName + " not found");
        }
        return commands.get(commandName);
    }


}
