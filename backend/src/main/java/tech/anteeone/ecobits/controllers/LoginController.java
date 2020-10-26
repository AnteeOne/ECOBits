package tech.anteeone.ecobits.controllers;

import tech.anteeone.ecobits.configs.ConfigRepository;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.repositories.UserRepository;
import tech.anteeone.ecobits.services.UserSecurityService;
import tech.anteeone.ecobits.services.UserValidatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if(UserValidatorService.loginDataIsValid(email,password)){
            User user = new User(email,password);
            UserRepository dbService = new UserRepository();
            if(dbService.checkUserData(user)){
                session.setAttribute("user_session",
                        UserSecurityService.generateUserSessionCode(user, ConfigRepository.SECURITY_KEY));
                session.setMaxInactiveInterval(300);
                resp.sendRedirect("home");
            }
            else{
                session.setAttribute("error","Password or Email is incorrect");
                session.setMaxInactiveInterval(1);
                getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
        else{
            session.setAttribute("error","Fields's not valid");
            session.setMaxInactiveInterval(1);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

}
