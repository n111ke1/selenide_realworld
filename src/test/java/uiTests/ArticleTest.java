package uiTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ArticleDetailsPage;
import pages.HomePage;
import pages.ProfilePage;

public class ArticleTest extends BaseTest {

    @Test
    public void createNewPostTest(){
        new HomePage()
                .clickNewPost()
                .createNewDefaultPost();
        Assertions.assertThat(new ArticleDetailsPage().getArticleTitleText()).isEqualTo("TestArticleTitle");
        new ArticleDetailsPage().clickDeleteArticle();

    }

    @Test
    public void editExistsPost(){
//        new HomePage(driver);
//                .clickNewPost()
//                .createNewDefaultPost()
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

    @Test(enabled = false) //needs pre'conditions
    public void deletePost(){
        new HomePage()
                .clickNewPost()
                .createNewDefaultPost()
                .clickDeleteArticle();
        new HomePage()
                .clickProfile();
        Assertions.assertThat(new ProfilePage().getArticlesSize()).isNull();

    }
}
