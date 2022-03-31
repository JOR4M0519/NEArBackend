package co.edu.unbosque.nearbackend.dtos;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    private String username;

    @CsvBindByName
    private  String password;

    @CsvBindByName
    private String role;


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
}