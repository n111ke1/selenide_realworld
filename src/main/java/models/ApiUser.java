package models;

import lombok.Data;

@Data
public class ApiUser {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
