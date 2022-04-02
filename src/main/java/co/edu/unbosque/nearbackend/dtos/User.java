package co.edu.unbosque.nearbackend.dtos;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    private String email;
    @CsvBindByName
    private String username;
    @CsvBindByName
    private String password;
    @CsvBindByName
    private String role;
    @CsvBindByName
    private String Fcoins;

    public User() {
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getFcoins() {return Fcoins;}

    public void setFcoins(String fcoins) {Fcoins = fcoins;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", Fcoins='" + Fcoins + '\'' +
                '}';
    }
}

