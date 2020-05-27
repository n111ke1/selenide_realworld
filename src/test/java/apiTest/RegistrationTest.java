package apiTest;

import io.restassured.RestAssured;
import models.User;
import models.UserData;
import models.UserResponce;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseApiTest{


    @Test
    public void registrationUserTest() {
        User user = UserData.randomUser();
        UserResponce userResponce = new UserResponce();
        userResponce.setUser(user);

        User newUser = RestAssured
                .given()
                    .body(userResponce)
                .when()
                    .post("/users")
                .then()
                    .statusCode(200)
                    .extract().body()
                    .as(UserResponce.class)
                    .getUser();

        assertThat(newUser.getEmail()).isEqualToIgnoringCase(user.getEmail());
        assertThat(newUser.getUsername()).isEqualToIgnoringCase(user.getUsername());
    }



}
