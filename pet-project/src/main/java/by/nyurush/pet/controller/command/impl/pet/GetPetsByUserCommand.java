package by.nyurush.pet.controller.command.impl.pet;

import by.nyurush.pet.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.nyurush.pet.factory.BeanFactory.getPetService;

public class GetPetsByUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getRequestURI();
        String id = path.replaceAll("[^0-9]", "");
        sendAsJson(resp, getPetService().findAllByUser(Long.parseLong(id)));
    }
}
