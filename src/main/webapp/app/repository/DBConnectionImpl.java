package main.webapp.app.repository;

import main.webapp.app.servlets.RegisterImpl;

import java.sql.*;

import static java.lang.System.out;

public class  DBConnectionImpl implements DBConnection {

    private final String url = "jdbc:h2:E:\\Programowanie\\Java\\MyWebApp/my-local";
    private final String dbDriver = "oracle.jdbc.Driver";


    private Connection connection = DriverManager.getConnection(url,"sa","");
    private Statement statement;
    private ResultSet resultSet;

    public final String regQuery = "insert into users " +
            " (name,password,mail,country)" +
            " values (?,?,?,?);";

    public  DBConnectionImpl() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url,"sa","")) {

            try (Statement statement = connection.createStatement();){
                statement.execute
                        ("CREATE TABLE IF NOT EXISTS users (" +
                        "id number(6,0) not null AUTO_INCREMENT primary key," +
                        "name varchar2(20) not null," +
                        "password varchar2(12) not null," +
                        "mail varchar2(40) not null," +
                        "country varchar(20));");
            }


        } catch (SQLException a)
        {
            a.printStackTrace();
        }




    }

    @Override
    public long registerUser(User user)  {

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
        }
        catch (Exception bla) {
            out.println("jakis wyjatek");
        }
        return 0;
    }
}

