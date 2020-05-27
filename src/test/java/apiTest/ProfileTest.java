package apiTest;

import io.restassured.RestAssured;
import models.User;
import models.UserData;
import org.testng.annotations.Test;
import serviceApi.UserService;

public class ProfileTest extends BaseApiTest {
    User user;

    @Test
    public void getExistProfile(){
    UserService userService = new UserService();
    user = userService.registration();
    RestAssured
            .given()
            .when()
            .get("/profiles/" + user.getUsername())
            .then()
            .statusCode(200)
            .log().all();
}

    @Test
    public void followUser(){
        user =  UserData.defaultUser();
        RestAssured
                .given()
                .when()
                .post("/profiles/" + user.getUsername() + "/follow")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void unFollowUser(){
        user =  UserData.defaultUser();
        RestAssured
                .given()
                .when()
                .delete("/profiles/" + user.getUsername() + "/follow")
                .then()
                .statusCode(200)
                .log().all();
    }


}
