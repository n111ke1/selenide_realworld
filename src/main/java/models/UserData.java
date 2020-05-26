package models;

import com.github.javafaker.Faker;

public class UserData {
    public static User defaultUser() {
        return new User("niktest@email.com","qwerty12345");
    }

    public static User randomUser() {
        Faker faker = new Faker();
        User user = new User();
        user.setUsername(faker.name().username());
        user.setEmail(faker.name().lastName() + "@mail.com");
        user.setPassword("qwerty123");
        return user;
    }

}
