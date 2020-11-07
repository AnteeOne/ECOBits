package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.models.Order;
import tech.anteeone.ecobits.models.User;

public class ShopService {

    private static ShopService sc;

    public boolean userCanBuyOrder(User user, Order order){
        return user.getBitsCount() >= order.getBitsPrice();
    }

    public static ShopService getInstance(){
        if(sc == null) sc = new ShopService();
        return sc;
    }
}
