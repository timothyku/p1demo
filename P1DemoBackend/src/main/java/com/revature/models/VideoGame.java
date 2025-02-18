package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component //Make the class a bean
@Entity //This makes the class a DB entity
@Table(name = "video_games")
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    @Column(nullable = false) //every game must have a title
    private String title;

    private String genre;

    /* Foreign Key connection to the users table PK

     -cascade: defines how changes to User records will affect videogames records
        -cascade.ALL = any change to User will be reflected in dependent records

     -fetch: defines when the data gets loaded
        -FetchType.EAGER = dependencies are loaded when the app starts
        -FetchType.LAZY = dependencies are loaded on an as-needed basic

    -What's a dependency? In this case, videogames has a FK to user
        -User is a dependency of videogames
        -When we fetch a videogame, the DB fetches the appropriate user

    -JoinColumn: this is how we reference the PK of the users table
    */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    //boilerplate -----------------

    public VideoGame() {
    }

    public VideoGame(int gameId, String title, String genre, User user) {
        this.gameId = gameId;
        this.title = title;
        this.genre = genre;
        this.user = user;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VideoGames{" +
                "gameId=" + gameId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", user=" + user +
                '}';
    }
}
