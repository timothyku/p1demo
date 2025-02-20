package com.revature.controllers;

import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<OutgoingUserDTO> registerUser(@RequestBody User user){

        //Send the User data to the service (which will send it to the DAO)
        OutgoingUserDTO returnedUser = authService.registerUser(user);

        //Send the inserted User back to the client in a response
        return ResponseEntity.ok(returnedUser);
        //.ok() sends a 200 OK status code and allows us to send a response body

    }

    //Login (POST request)
    @PostMapping("/login")
    public ResponseEntity<OutgoingUserDTO> login(@RequestBody LoginDTO loginDTO, HttpSession session){

        //Note: we have an HttpSession coming in through parameters, implicitly included in every HTTP request
        //Login is the main place we'll use it

        //try to login (send the loginDTO to the service)
        OutgoingUserDTO loggedInUser = authService.login(loginDTO);
        //If anything goes wrong, the service throws an exception and our global Exception handler takes over

        //If we get here, the login was successful - we can build up the User's session!
        session.setAttribute("userId", loggedInUser.getUserId());
        session.setAttribute("username", loggedInUser.getUsername());
        session.setAttribute("role", loggedInUser.getRole());

        //it's really easy to access these values with getAttribute()!
        System.out.println("User " + session.getAttribute("username") + "has logged in!");

        /* WHY store all this info in a Session?

            -It lets us store user info that can be used for checks throughout the app
                -check that the user is logged in (session != null)
                -check that a user's role is appropriate (role.equals("admin"))
                -personalize the app (use the user's name in HTTP responses to use them in the UI etc)
                -simplify our URLs!
                    -e.g. use the stored userId in "findSomethingByUserId" methods instead of sending it in the PATH
                    -This cleans up our URLs and secures them a bit more too.
         */

        //Return the Uesr info to the client
        return ResponseEntity.ok(loggedInUser);
    }

}
