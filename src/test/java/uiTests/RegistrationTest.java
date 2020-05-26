package uiTests;

import models.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MainPage;
import pages.SignUpPage;

public class RegistrationTest {
    User user;

    @Test
    public void registration() {
        new MainPage()
                .clickSignUp();
        new SignUpPage()
                .inputUserName(user.getUsername())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickSignInBtn();
        Assertions.assertThat(new HomePage().isUserLoggedIn(user.getUsername()));
    }

    @Test
    public void registrationFormValidation(){
        new MainPage()
                .clickSignUp();
        new SignUpPage()
                .clickSignInBtn();
        Assertions.assertThat(new SignUpPage().getErrorEmailText()).isEqualTo("email can't be blank");
        Assertions.assertThat(new SignUpPage().getErrorPassText()).isEqualTo("password can't be blank");
        Assertions.assertThat(new SignUpPage().getErrorUserNameText()).isEqualTo("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");

    }
}
