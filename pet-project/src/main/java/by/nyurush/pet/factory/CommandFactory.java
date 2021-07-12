package by.nyurush.pet.factory;

import by.nyurush.pet.controller.command.Command;
import by.nyurush.pet.controller.command.impl.pet.AddPetCommand;
import by.nyurush.pet.controller.command.impl.pet.DeletePetCommand;
import by.nyurush.pet.controller.command.impl.pet.GetAllCatsCommand;
import by.nyurush.pet.controller.command.impl.pet.GetAllDogsCommand;
import by.nyurush.pet.controller.command.impl.pet.GetAllPetsCommand;
import by.nyurush.pet.controller.command.impl.pet.GetPetByIdCommand;
import by.nyurush.pet.controller.command.impl.pet.GetPetsByUserCommand;
import by.nyurush.pet.controller.command.impl.user.AddUserCommand;
import by.nyurush.pet.controller.command.impl.user.DeleteUserCommand;
import by.nyurush.pet.controller.command.impl.user.GetAllUsersCommand;
import by.nyurush.pet.controller.command.impl.user.GetUserByIdCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("get_users", new GetAllUsersCommand());
        commands.put("get_users/id", new GetUserByIdCommand());
        commands.put("get_users/id/pets", new GetPetsByUserCommand());

        commands.put("get_pets", new GetAllPetsCommand());
        commands.put("get_pets/id", new GetPetByIdCommand());
        commands.put("get_pets/cats", new GetAllCatsCommand());
        commands.put("get_pets/dogs", new GetAllDogsCommand());

        commands.put("post_users", new AddUserCommand());
        commands.put("post_pets", new AddPetCommand());

        commands.put("put_users/id", new AddUserCommand());
        commands.put("put_pets/id", new AddPetCommand());

        commands.put("delete_users/id", new DeleteUserCommand());
        commands.put("delete_pets/id", new DeletePetCommand());
    }

    public static Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
