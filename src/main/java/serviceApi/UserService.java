package serviceApi;

import io.restassured.RestAssured;
import models.User;
import models.UserData;
import models.UserResponce;

public class UserService extends BaseApiService {


    public User login() {
        User defUser = UserData.defaultUser();
        UserResponce userResponce = new UserResponce();
        userResponce.setUser(defUser);
        setUp();
        User userAuth =  RestAssured
                .given()
                    .body(userResponce)
                .when()
                    .post("/users/login")
                .then()
                    .statusCode(200)
                    .extract().body()
                    .as(UserResponce.class)
                    .getUser();
        userAuth.setPassword(defUser.getPassword());
      return userAuth;
    }


    public User registration(){
     User userData = UserData.randomUser();
     UserResponce userResponce = new UserResponce();
     userResponce.setUser(userData);
        setUp();
        User newUser = RestAssured
                .given()
                    .body(userResponce)
                .when()
                    .post("/users")
                .then()
                    .statusCode(200)
                    .extract().body()
                    .as(UserResponce.class).getUser();
        newUser.setPassword(userData.getPassword());
    return newUser;
    }




}
