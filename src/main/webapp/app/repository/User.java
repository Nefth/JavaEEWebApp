package app.repository;

public class User {
    private String name;
    private String email;
    private String pwd;
    private String country;


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
