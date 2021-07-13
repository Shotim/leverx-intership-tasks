package by.nyurush.pet.controller;

import by.nyurush.pet.controller.command.Command;
import by.nyurush.pet.factory.CommandFactory;
import by.nyurush.pet.util.StringConstants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class PetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = StringConstants.GET + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = StringConstants.POST + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = StringConstants.PUT + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String commandStr = StringConstants.DELETE + prepareUriForCommand(req.getRequestURI());

        Command command = CommandFactory.getCommand(commandStr);
        command.execute(req, resp);
    }

    private String prepareUriForCommand(String uri) {
        String commandStr = uri.substring(1);
        return commandStr.replaceAll("/[\\d]+", "/id");
    }
}
