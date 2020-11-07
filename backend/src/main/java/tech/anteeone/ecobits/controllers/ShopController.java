package tech.anteeone.ecobits.controllers;

import tech.anteeone.ecobits.models.Order;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.repositories.QuestRepository;
import tech.anteeone.ecobits.repositories.ShopRepository;
import tech.anteeone.ecobits.repositories.UserRepository;
import tech.anteeone.ecobits.services.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shop")
public class ShopController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("orderList", ShopRepository.getInstance().getAll());
        getServletContext().getRequestDispatcher("/shop.jsp").forward(req,resp);
        HttpSession session = req.getSession();
        session.setAttribute("shoperror","");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        HttpSession session = req.getSession();
        if (type.equals("buyorder")){
            Integer orderId = Integer.valueOf(req.getParameter("orderid"));
            Order order = ShopRepository.getInstance().getById(orderId);
            User user = (User) new UserRepository().getUserFromSession(session.getAttribute("user_session").toString());
            if(ShopService.getInstance().userCanBuyOrder(user,order)){
                UserRepository.getInstance().updateUsersBits(user.getId(),order.getBitsPrice() * (-1));
                session.setAttribute("shoperror","");
            }
            else{
                session.setAttribute("shoperror","You don't have enough bits to buy this order :(");
            }
            resp.sendRedirect("shop");
        }
    }
}
