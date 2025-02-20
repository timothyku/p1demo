package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.DAOs.VideoGameDAO;
import com.revature.models.DTOs.IncomingGameDTO;
import com.revature.models.User;
import com.revature.models.VideoGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //1 of 4 stereotype annotations (make a class a bean)
public class VideoGameService {

    //Autowire the UserDAO and VideoGameDAO
    private final UserDAO userDAO;
    private  final VideoGameDAO videoGameDAO;

    @Autowired
    public VideoGameService(UserDAO userDAO, VideoGameDAO videoGameDAO) {
        this.userDAO = userDAO;
        this.videoGameDAO = videoGameDAO;
    }

    //Insert a new game into DB (get user by ID and make a game object with it)
    public VideoGame insertGame(IncomingGameDTO gameDTO){

        //TODO: input validation

        //Skeleton VideoGame object first
            // 0 for id since the DB will handle that
            // null for the User since we need to get it first
        VideoGame newGame = new VideoGame(
                0,
                gameDTO.getTitle(),
                gameDTO.getGenre(),
                null
        );

        //We need to use the userID from the DTO to get a User from the DB
        //findById() returns an Optional
        Optional<User> user = userDAO.findById(gameDTO.getUserId()); //optional help uss avoid no-pointer exception

        //if the user doesn't exist it will be empty
        if(user.isEmpty()){
            //TODO: throw an exception
        } else {
            //If the user exists, we can set it in the game object
            newGame.setUser(user.get());
            //get() is how we extract data from an optional
        }

        //save the new game to the DB, and return it ot the controller
        return videoGameDAO.save(newGame);

    }

    //TODO: Get games by user ID
}
