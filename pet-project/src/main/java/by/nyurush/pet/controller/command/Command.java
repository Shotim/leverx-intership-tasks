package by.nyurush.pet.controller.command;

import by.nyurush.pet.util.StringConstants;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static by.nyurush.pet.util.StringConstants.APP_JSON;

public interface Command {

    void execute(HttpServletRequest req, HttpServletResponse resp);

    default void sendAsJson(HttpServletResponse response, Object obj) {
        response.setContentType(APP_JSON);

        Gson gson = new Gson();
        String res = gson.toJson(obj);
        try (PrintWriter out = response.getWriter()) {
            out.print(res);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("Cannot send response.");
        }
    }
}
