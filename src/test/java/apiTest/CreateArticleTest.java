package apiTest;

import io.restassured.RestAssured;
import models.Article;
import models.ArticleResponse;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import serviceApi.UserService;

import java.util.Arrays;

public class CreateArticleTest extends BaseApiTest {

    Article articleNew;
    User user;

    @BeforeMethod
    public User authenticationToken(){
        UserService userService = new UserService();
        user = userService.registration();
        return user;
    }


    @Test
    public void createArticle(){
        ArticleResponse articleResponse = new ArticleResponse();
        Article article = new Article();
        article.setTitle("dwad");
        article.setDescription("dwad");
        article.setBody("dawdawd");
        article.setTagList(Arrays.asList("test", "dawddad"));
        articleResponse.setArticle(article);

        articleNew = RestAssured
               .given()
                    .header("Authorization", "Token " + user.getToken())
                    .body(article)
                .when()
                    .post("/articles")
                .then()
                    .statusCode(200)
                    .extract().body()
                    .as(ArticleResponse.class).getArticle();
        System.out.println(articleNew);
        deleteArticle();
    }


    public void deleteArticle(){
    RestAssured
            .given()
            .when()
                .delete("/articles/" + articleNew.getSlug())
            .then()
                .statusCode(200)
            .log().all();

    }

}
