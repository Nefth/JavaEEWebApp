package app.repository;

import app.repository.DBConnection;
import app.repository.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private String type;
    private int lenght;
    private int rating;
    private String description;
    DBConnection dbConnection;

    public Movie(String title, String type, int lenght, String description) {
        this.title = title;
        this.type = type;
        this.lenght = lenght;
        this.description = description;

        rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public List<Movie> movieList(User user) {
        List<Movie> list = new ArrayList<>();

        return list;
    }


}
