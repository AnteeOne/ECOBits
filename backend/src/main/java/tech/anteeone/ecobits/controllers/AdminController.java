package tech.anteeone.ecobits.controllers;

import tech.anteeone.ecobits.models.Quest;
import tech.anteeone.ecobits.repositories.QuestRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("questList", QuestRepository.getInstance().getAll());
        getServletContext().getRequestDispatcher("/admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equals("addquest")){
            String questTitle = req.getParameter("quest_title");
            String questText = req.getParameter("quest_text");
            Integer questBits = Integer.valueOf(req.getParameter("quest_bits"));
            Quest quest = new Quest(questTitle,questText,questBits);
            QuestRepository.getInstance().create(quest);
            resp.sendRedirect("admin");
        }
        if(type.equals("deletequest")){
            QuestRepository.getInstance().delete(Integer.valueOf(req.getParameter("questid")));
            resp.sendRedirect("admin");
        }
    }
}
