package by.nyurush.pet.controller.command.impl.user;

import by.nyurush.pet.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.nyurush.pet.factory.BeanFactory.getUserService;

public class DeleteUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getRequestURI();
        String id = path.substring(path.lastIndexOf('/') + 1);

        getUserService().delete(Long.parseLong(id));
    }
}
