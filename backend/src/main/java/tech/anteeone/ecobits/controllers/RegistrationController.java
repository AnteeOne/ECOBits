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

@WebServlet("/register")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        User user = new User(username,email,password,password2);
        HttpSession session = req.getSession();

        if(UserValidatorService.userIsValid(user)){
            UserRepository userRepository = new UserRepository();
            if(userRepository.emailIsAvailable(user)){
                if(userRepository.userSignUp(user)){
                    session.setAttribute("user_session",
                            UserSecurityService.generateUserSessionCode(user, ConfigRepository.SECURITY_KEY));
                    session.setMaxInactiveInterval(300);
                    resp.sendRedirect("home");

                }
                else{
                    session.setAttribute("error","Fields is incorrect");
                    session.setMaxInactiveInterval(1);
                    getServletContext().getRequestDispatcher("/register.jsp").forward(req,resp);
                }
            }

            else{
                session.setAttribute("error","Email is Unavailable");
                session.setMaxInactiveInterval(1);
                getServletContext().getRequestDispatcher("/register.jsp").forward(req,resp);
            }

        }
        else{
            session.setAttribute("error","Field's not valid.Passwords didn't match");
            session.setMaxInactiveInterval(1);
            getServletContext().getRequestDispatcher("/register.jsp").forward(req,resp);
        }



    }

}
