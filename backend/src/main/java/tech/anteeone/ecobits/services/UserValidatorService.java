package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.models.User;

public class UserValidatorService {

    public static boolean userIsValid(User user){
        return   user.getPassword().equals(user.getPassword2()) &&
                !user.getPassword().equals("") &&
                !user.getEmail().equals("") &&
                !user.getUsername().equals("");

    }

    public static boolean loginDataIsValid(String email,String password){
        return !email.equals("") &&
                !password.equals("");
    }
}
