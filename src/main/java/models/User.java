package models;


import lombok.Data;

import java.util.Date;

@Data
public class User {
    private long id;
    private String token;
    private String bio;
    private String username;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private String image;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(){}
}
