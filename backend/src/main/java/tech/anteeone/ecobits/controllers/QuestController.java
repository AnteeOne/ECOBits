package tech.anteeone.ecobits.controllers;



import tech.anteeone.ecobits.repositories.QuestRepository;

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
        if(session.getAttribute("user_session") == null){
            resp.sendRedirect(req.getContextPath());
        }
        else{
            System.out.println(QuestRepository.getInstance().getQuests().toString());
            req.setAttribute("questList", QuestRepository.getInstance().getQuests());
            getServletContext().getRequestDispatcher("/quests.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
