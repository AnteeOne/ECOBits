package tech.anteeone.ecobits.controllers;

import tech.anteeone.ecobits.ConfigReposytory;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.services.UserRepository;
import tech.anteeone.ecobits.services.UserSecurityService;
import tech.anteeone.ecobits.services.UserValidator;

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

        if(UserValidator.userIsValid(user)){
            UserRepository userRepository = new UserRepository();
            if(userRepository.emailIsAvailable(user)){
                if(userRepository.userSignUp(user)){
                    HttpSession session = req.getSession();
                    session.setAttribute("user_session",
                            UserSecurityService.generateUserSessionCode(user, ConfigReposytory.SECURITY_KEY));
                    session.setMaxInactiveInterval(300);
                    //TODO:REDIRECT TO QUEST PAGE(red:success page)
                }
            }
            //TODO:EMAIL IS UNAVAILABLE(red:error page)

        }


        //TODO:CHECK USER'S DATA
        //TODO CHECK IF THIS EMAIL IS BUSY
    }

}
