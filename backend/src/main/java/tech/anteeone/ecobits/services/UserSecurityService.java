package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.models.User;

public class UserSecurityService {

    public static String hashPassword(String password,String key){

        return String.valueOf(password.hashCode()) + key.hashCode();

    }

    public static String generateUserSessionCode(User user, String securityKey){
        return "" + user.getEmail().hashCode() +
                    user.getPassword().hashCode() +
                    securityKey;
    }

}
