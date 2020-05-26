package uiTests;

import models.User;
import models.UserData;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.MainPage;
import pages.SignInPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationUserTest extends BaseTest {
    private User user = UserData.defaultUser();

    @Test
    public void loginUserTest(){
        new MainPage()
                .clickSignIn();
        new SignInPage()
                .login(user.getEmail(), user.getPassword());
        assertThat(new HomePage().isUserLoggedIn(user.getUsername())).isTrue();
    }

    @Test()
    public void loginFormValidation(){
        new MainPage()
                .clickSignIn();
        new SignInPage()
                .clickSingInButton();
        assertThat(new SignInPage().getErrorText()).isEqualTo("email or password is invalid");
    }

}
