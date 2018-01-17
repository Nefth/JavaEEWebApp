package main.webapp.app.repository;

public class User {
    public String name;
    public String email;
    public String pwd;
    public String country;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getCountry() {
        return country;
    }

    public User(String name, String email, String pwd, String country) {

        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.country = country;
    }
}
