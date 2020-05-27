package uiTests;

import models.Article;
import models.User;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import serviceApi.ArticleService;
import serviceApi.UserService;

public class ArticleTest extends BaseTest {
    private User user;
    private Article article;


    @BeforeMethod
    public void beforeTestRegNewUserApi(){
        UserService userService = new UserService();
        user =  userService.registration();

        new MainPage()
                .clickSignIn();
        new SignInPage()
                .login(user.getEmail(), user.getPassword());

    }

    @Test
    public void createNewPostTest(){
       article = new HomePage()
                .clickNewPost()
                .createNewDefaultPost();
        Assertions.assertThat(new ArticleDetailsPage().getArticleTitleText()).isEqualTo("TestArticleTitle");
        new ArticleDetailsPage().clickDeleteArticle();

    }

    @Test
    public void editExistsPost(){

        new HomePage()
                .clickProfile()
                .clickOnArticleTitle();
        new ArticleDetailsPage()
                .clickEditPost()
                .inputArticleTitle("SomeNewTitle")
                .inputWhatArticleAbout( "about article")
                .inputArticle("changed text text text")
                .inputTags("@newTag")
                .clickPublishArticleBtn();
        Assertions.assertThat(new ArticleDetailsPage().getArticleTitleText()).isEqualTo("SomeNewTitle");
        new ArticleDetailsPage().clickDeleteArticle();
    }

    @Test
    public void deletePost(){
        new HomePage()
                .clickNewPost()
                .createNewDefaultPost()
                .clickDeleteArticle();
        new HomePage()
                .clickProfile();
        Assertions.assertThat(new ProfilePage().getArticlesSize()).isNull();

    }

    @AfterMethod
    public void deleteArticles(){
        ArticleService articleService = new ArticleService(user.getToken());
        articleService.deleteArticle(article);
    }
}
