package main.webapp.app.repository;

import app.repository.DBConnection;
import app.repository.DBConnectionImpl;
import app.servlets.LoginImpl;
import com.sun.media.sound.SimpleSoundbank;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void tryLoginUser_should_return_true_when_insert_correct_mail_and_pass() throws SQLException {

        //given
        String mail = "123@wp.pl";
        String password = "123";
        DBConnection dbConnection = new DBConnectionImpl();

        //when

        boolean value = dbConnection.tryLoginUser(mail, password);

        //then
        Assert.assertTrue(value);


    }

    @Test
    public void bla() throws SQLException {

        //given

        String mail = null;
        String password = "  ";
        DBConnection dbConnection = new DBConnectionImpl();

        //when

        boolean a = dbConnection.tryLoginUser(mail, password);

        //then

        Assert.assertFalse(a);


    }
}
