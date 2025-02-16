package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


//AuthController? Think AUTHentication/AUTHorization
//I like to put account registration and login functionality here

@RestController // Combines @Controller and @ResponseBody (makes a class a bean and let us send JSON responses)
@RequestMapping("/auth") //Requests ending in /auth will go to this Controller
@CrossOrigin //This annotation will allow requests from anywhere (like our React App)
public class AuthController {

    //autowire the AuthService to use its methods
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //Insert a new user (POST request)
    @PostMapping("/register") //Requests ending in /auth/register will invoke this method
    public ResponseEntity<User> registerUser(@RequestBody User user){

        //Send the User data to the service (which will send it to the DAO)
        User returnedUser = authService.registerUser(user);

        //Send the inserted User back to the client in a response
        return ResponseEntity.ok(returnedUser);
        //.ok() sends a 200 OK status code and allows us to send a response body


    }


}
