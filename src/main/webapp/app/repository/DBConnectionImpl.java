package app.repository;

import app.servlets.RegisterImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.out;

public class  DBConnectionImpl implements DBConnection {

    private final String url = "jdbc:h2:E:\\Programowanie\\Java\\MyWebApp/my-local";
    private final String dbDriver = "oracle.jdbc.Driver";


    private Connection connection = DriverManager.getConnection(url, "sa", "");
    private Statement statement;
    private ResultSet resultSet;

    public final String regQuery = "insert into users " +
            " (name,password,mail,country)" +
            " values (?,?,?,?);";

    public final String loginQuery = "select MAIL, PASSWORD from USERS;";

    public DBConnectionImpl() throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, "sa", "")) {

            try (Statement statement = connection.createStatement()) {
                statement.execute
                        ("CREATE TABLE IF NOT EXISTS users (" +
                                "id number(6,0) not null AUTO_INCREMENT primary key," +
                                "name varchar2(20) not null," +
                                "password varchar2(12) not null," +
                                "mail varchar2(40) not null," +
                                "country varchar(20));");
                statement.execute
                        ("CREATE TABLE IF NOT EXISTS movies (" +
                                "id number(6,0) not null AUTO_INCREMENT primary key," +
                                "title varchar2(20) not null," +
                                "type varchar2(20) not null," +
                                "lenght number(4,0) not null," +
                                "description varchar2(255) not null);");
            }


        } catch (SQLException a) {
            a.printStackTrace();
        }


    }

    @Override
    public long registerUser(User user) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(regQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPwd());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());

            int check = preparedStatement.executeUpdate();

            if (check != 1) {
                throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", check));
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new IllegalStateException("Query did not return created primary key");
                }

                out.println("Generated id is = " + generatedKeys.getLong(1));

                return generatedKeys.getLong(1);
            }

        } catch (SQLException ex) {
            throw new IllegalStateException("Could not execute query", ex);

        } catch (NullPointerException ex2) {
            out.println("wywala tutaj  na null");
            ex2.printStackTrace();
        } catch (Exception bla) {
            out.println("jakis wyjatek");
        }
        return 0;
    }

    @Override
    public boolean tryLoginUser(String mail, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next())
                    if (resultSet.getString(1).equals(mail) && resultSet.getString(2).equals(password))
                        return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean checkRegistration(User user) throws SQLException {
        String QueryReg = "select * from USERS where MAIL = ? or NAME = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueryReg)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next())
                return false;
        }

        return true;

    }

    @Override
    public List<Movie> movieList() throws SQLException {
        List<Movie> list = new ArrayList<>();
        String QueryMovieList = "select * from movies";
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueryMovieList)) {
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        return null;
    }
}