package app.services;

import app.repository.Movie;
import app.repository.User;

import java.util.List;

public interface MovieService {
    boolean addMovie(String title, String type, int length, String description, User user);

    //public boolean editMovie(long idMovie);

    //public List<Movie> listAllMovie();

    //public List<Movie> filteredListMovie(List<String> listParam);


}
