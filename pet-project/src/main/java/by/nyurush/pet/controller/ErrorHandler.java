package by.nyurush.pet.controller;

import by.nyurush.pet.dto.ResponseExceptionDto;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static by.nyurush.pet.util.StringConstants.EXC_ATTR;
import static by.nyurush.pet.util.StringConstants.REQUEST_URI_ATTR;
import static by.nyurush.pet.util.StringConstants.SERVLET_ATTR;
import static by.nyurush.pet.util.StringConstants.UNKNOWN;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        getProcess(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        doGet(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doGet(req, resp);
    }

    private void getProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RuntimeException exception = (RuntimeException)
                request.getAttribute(EXC_ATTR);
        String servletName = (String)
                request.getAttribute(SERVLET_ATTR);

        if (servletName == null) {
            servletName = UNKNOWN;
        }
        String requestUri = (String)
                request.getAttribute(REQUEST_URI_ATTR);

        if (requestUri == null) {
            requestUri = UNKNOWN;
        }

        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        response.setStatus(SC_NOT_FOUND);

        ResponseExceptionDto dto = new ResponseExceptionDto();
        dto.setServletName(servletName);
        dto.setExceptionType(exception.getClass().getName());
        dto.setRequestUri(requestUri);
        dto.setExceptionMessage(exception.getMessage());

        out.print(gson.toJson(dto));
    }
}
