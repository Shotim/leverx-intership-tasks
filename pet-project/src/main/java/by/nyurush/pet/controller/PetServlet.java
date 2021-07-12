package by.nyurush.pet.controller;

import by.nyurush.pet.controller.command.Command;
import by.nyurush.pet.factory.CommandFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class PetServlet extends HttpServlet {

    private final static String GET = "get_";
    private final static String POST = "post_";
    private final static String PUT = "put_";
    private final static String DELETE = "delete_";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = GET + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = POST + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = PUT + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = DELETE + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    private String prepareUriForCommand(String uri) {
        String commandStr = uri.substring(1);
        return commandStr.replaceAll("/[\\d]+", "/id");
    }
}
