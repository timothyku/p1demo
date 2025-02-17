package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;

    //Autowire the DAO so we can use its method
    @Autowired public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //Get all users from the DB
    public List<OutgoingUserDTO> getAllUser(){

        //For get all, we don't have to do much user input validation
        //There's no user input! We just want to get all the data
        List<User> returnedUsers = userDAO.findAll();

        //convert the users into a list of UserDTOs
        //we're going to use our special "User args" constructor from the DTO
        List<OutgoingUserDTO> userDTOs = new ArrayList<>();

        //loop through the users, convert them, and add to DTO list
        for(User u : returnedUsers){
            userDTOs.add(new OutgoingUserDTO(u));
        }
        //return userDAO.findAll(); <- the method was used to just be this before refactoring
        return userDTOs;
    }
}
