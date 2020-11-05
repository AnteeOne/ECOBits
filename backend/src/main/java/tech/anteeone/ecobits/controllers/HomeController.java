package tech.anteeone.ecobits.controllers;

import tech.anteeone.ecobits.models.Quest;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.repositories.QuestRepository;
import tech.anteeone.ecobits.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) new UserRepository().getUserFromSession(req.getSession().getAttribute("user_session").toString());
        if(user.getActiveQuestId() != null){
            Quest activeQuest = new QuestRepository().getById(user.getActiveQuestId());
            req.setAttribute("activeQuest",activeQuest);
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
