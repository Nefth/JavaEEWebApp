package app.services;

import app.repository.DBConnection;
import app.repository.DBConnectionImpl;
import app.repository.Movie;
import app.repository.User;

import java.sql.SQLException;

public class MovieServiceImpl implements MovieService {

    DBConnection dbConnection;

    public boolean addMovie(String title, String type, int length, String description, User user) {

        Movie movie = new Movie(title, type, length, description);

        movie.setAuthor(user.getName());

        try {
            dbConnection = new DBConnectionImpl();
            if (dbConnection.addMovie(movie) == true) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

}
