package com.project.atm.service;

import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    public static final Map<Integer, String> users = new HashMap<>();

    //sample user data
    static {
        users.put(12345, "password");
        users.put(54321, "helloworld");
    }

    public boolean authenticateUser(int accountNumber, String password){
        if (users.containsKey(accountNumber)) {
            String storedPassword = users.get(accountNumber);
            return (storedPassword.equals(password));
        }
        return (false);
    }
}
