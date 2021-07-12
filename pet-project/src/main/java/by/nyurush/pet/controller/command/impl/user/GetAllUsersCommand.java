package by.nyurush.pet.controller.command.impl.user;

import by.nyurush.pet.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.nyurush.pet.factory.BeanFactory.getUserService;

public class GetAllUsersCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        sendAsJson(resp, getUserService().findAll());
    }
}
