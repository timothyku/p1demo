package com.revature.controllers;

import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController //Make this class a bean and turn HTTP respnose bodies into JSON
@RequestMapping("/users") //Requests ending in users will go to this controller
@CrossOrigin //allow requests from anywhere
public class UserController {

    //Autowire the UserService to use its methods
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Return all users to the client
    @GetMapping //Get requests ending in /users will go here
    public ResponseEntity<List<OutgoingUserDTO>> getAllUsers(){

        //Let's return the Users in one line
        return ResponseEntity.ok(userService.getAllUser());

        //the parameter to .ok() is the RESPONSE BODY
        //AKA the data we're sending back
    }
}
