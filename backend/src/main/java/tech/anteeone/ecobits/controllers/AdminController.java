package tech.anteeone.ecobits.controllers;

import tech.anteeone.ecobits.models.Order;
import tech.anteeone.ecobits.models.Quest;
import tech.anteeone.ecobits.repositories.QuestRepository;
import tech.anteeone.ecobits.repositories.ShopRepository;

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
        req.setAttribute("orderList", ShopRepository.getInstance().getAll());
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
        if(type.equals("deleteorder")){
            ShopRepository.getInstance().delete(Integer.valueOf(req.getParameter("orderid")));
            resp.sendRedirect("admin");
        }
        if(type.equals("addorder")){
            String orderTitle = req.getParameter("order_title");
            String orderText = req.getParameter("order_text");
            Integer orderBits = Integer.valueOf(req.getParameter("order_bits"));
            Order order = new Order(orderTitle,orderText,orderBits);
            ShopRepository.getInstance().create(order);
            resp.sendRedirect("admin");
        }

    }
}
