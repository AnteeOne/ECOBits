package tech.anteeone.ecobits.controllers;



import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.repositories.QuestRepository;
import tech.anteeone.ecobits.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/quests")
public class QuestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("questList", QuestRepository.getInstance().getAll());
        getServletContext().getRequestDispatcher("/quests.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equals("choosequest")){
            HttpSession session = req.getSession();
            Integer questId = Integer.valueOf(req.getParameter("questid"));
            UserRepository.getInstance().updateUsersQuest(session.getAttribute("user_session").toString(),questId);
            resp.sendRedirect("quests");
        }
    }
}
