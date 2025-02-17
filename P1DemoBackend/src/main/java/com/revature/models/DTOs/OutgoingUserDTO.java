package com.revature.models.DTOs;

//This is a Data Transfer Object (DTO)
//They are often used to model data that is being sent between client and server

//In this case, we want to send User info without including that raw password
//Yes, we could have just made a different constructor in the User class
    //Check the video game DTOs for more interesting uses of DTO

import com.revature.models.User;

public class OutgoingUserDTO {

    private int userId;
    private String username;
    private String role;

    //boilerplate---------- constructor, getter/setter, to_string cmd+n

    public OutgoingUserDTO(int userId) {
        this.userId = userId;
    }

    public OutgoingUserDTO(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }
    //see this in use in get all users in UserService
    //way cleaner way to format a User into a DTO
    public OutgoingUserDTO(User u) {
        this.userId = u.getUserId();
        this.username = u.getUsername();
        this.role = u.getRole();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "OutgoingUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
