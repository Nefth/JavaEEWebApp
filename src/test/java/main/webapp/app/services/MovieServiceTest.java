package main.webapp.app.services;


import app.repository.User;
import app.services.MovieService;
import app.services.MovieServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class MovieServiceTest {

    @Test
    public void add_Movie_should_return_true_when_add_movie_to_database() {
        //given
        String title = "test";
        String type = "test";
        int length = 100;
        String description = "test test test";
        MovieService movieService = new MovieServiceImpl();
        User user = new User("test Name User", "test@test.pl", "testpass", "testcountry");
        //when

        boolean check = movieService.addMovie(title, type, length, description, user);

        //then

        Assert.assertTrue(check);
    }
}
