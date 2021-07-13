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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.nyurush.pet.util.StringConstants.DELETE;
import static by.nyurush.pet.util.StringConstants.GET;
import static by.nyurush.pet.util.StringConstants.POST;
import static by.nyurush.pet.util.StringConstants.PUT;

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
                || List.of(GET, POST, PUT, DELETE)
                .contains(commandName)) {

            throw new CommandNotFoundException("Command " + commandName + " not found");
        }
        return commands.get(commandName);
    }


}
