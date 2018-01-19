package main.webapp.app.repository;

import app.repository.User;
import junit.framework.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

public class UserTest {

    @Test
    public void create_User_should_return_ToStringUser_when_insered_correct_data() {
        //given
        String name = "";
        String email = "";
        String pass = "";
        String country = "";
        //when
        User user = new User(name, email, pass, country);
        //then
        Assert.assertNotNull(user);

    }
}
