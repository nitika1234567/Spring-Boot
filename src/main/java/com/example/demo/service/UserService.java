package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean login(User user)
    {
        if(user.getUsername().equals("Nitika") && user.getPassword().equals("chit"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
