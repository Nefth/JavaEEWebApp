package app.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DBConnection {
long registerUser (User user);

    boolean tryLoginUser(String mail, String password);

    boolean checkRegistration(User user) throws SQLException;

    List<Movie> movieList() throws SQLException;
}

