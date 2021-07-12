package by.nyurush.pet.controller.command.impl.user;

import by.nyurush.pet.controller.command.Command;
import by.nyurush.pet.entity.User;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.nyurush.pet.factory.BeanFactory.getUserService;

public class AddUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String jsonString = IOUtils.toString(req.getInputStream());
            User user = new Gson().fromJson(jsonString, User.class);

            String path = req.getRequestURI();
            if (path.matches("^.*\\d$")) {
                String id = path.substring(path.lastIndexOf('/') + 1);
                user.setId(Long.parseLong(id));
            }

            getUserService().save(user);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
