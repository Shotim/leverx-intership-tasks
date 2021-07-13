package by.nyurush.pet.controller.command.impl.pet;

import by.nyurush.pet.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.nyurush.pet.factory.BeanFactory.getPetService;
import static java.lang.Long.parseLong;

public class DeletePetCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getRequestURI();
        String id = path.substring(path.lastIndexOf('/') + 1);

        getPetService().delete(parseLong(id));
    }
}
