package apiTest;

import io.restassured.RestAssured;
import models.User;
import models.UserData;
import models.UserResponce;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseApiTest{

    @Test
    public void loginApiTest() {
//        File json = new File("src/test/resources/userData.json");
        User defUser = UserData.defaultUser();
        UserResponce userResponce = new UserResponce();
        userResponce.setUser(defUser);

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
        System.out.println(userAuth);
                assertThat(userAuth.getEmail()).isEqualToIgnoringCase(defUser.getEmail());
    }

}
