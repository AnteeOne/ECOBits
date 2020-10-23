package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.models.User;

public class UserValidator {

    public static boolean userIsValid(User user){
        return user.getPassword().equals(user.getPassword2());
    }
}
