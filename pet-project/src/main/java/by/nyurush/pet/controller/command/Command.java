package by.nyurush.pet.controller.command;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public interface Command {
    void execute(HttpServletRequest req, HttpServletResponse resp);

    default void sendAsJson(HttpServletResponse response, Object obj) {
        response.setContentType("application/json");

        Gson gson = new Gson();
        String res = gson.toJson(obj);
        try(PrintWriter out = response.getWriter()) {
            out.print(res);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
