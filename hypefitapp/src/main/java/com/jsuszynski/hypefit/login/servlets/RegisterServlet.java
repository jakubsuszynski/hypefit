package com.jsuszynski.hypefit.login.servlets;

import com.jsuszynski.hypefit.login.domain.User;
import com.jsuszynski.hypefit.login.tools.PasswordHash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String ADDRESS = "localhost:8080/hypefitapi/register";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User(PasswordHash.hashPassword(req), req.getParameter("login"), req.getParameter("email"), "user");
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(ADDRESS);

        Response response = webTarget.request().post(Entity.json(user));

        if (response.getStatus() == 200) {
            req.setAttribute("registerMessage", true);
            resp.sendRedirect("index.jsp");
        } else {
            req.setAttribute("registerMessage", false);
            resp.sendRedirect("users/register.jsp");
        }
        return;


    }
}
