package main.webapp.app.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface DBConnection {
long registerUser (User user);

}

