package tests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import tests.api.pages.CreatePostPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.title;
import static tests.TestData.titleType;

public class CreatePostTests extends TestDataApi {
    CreatePostPage createPostPage = new CreatePostPage();

@AfterAll
    static void cleanUp() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        deletePostPage.deletePost(accessToken,createPostModelJson.getJson().getData().getName());
    }
   @Test
   void CreatePostSuccessfulTest (){
       String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
       createPostModelJson = createPostPage.createPost(accessToken, username);

       assertThat(createPostModelJson.getJson().getData().getUrl()).isNotEmpty();
       assertThat(createPostModelJson.getJson().getData().getId()).isNotEmpty();
       assertThat(createPostModelJson.getJson().getData().getName()).isNotEmpty();
   }
    @Test
    void CreatePostIncorrectTokenTest (){
        String accessToken = "fdggdfgdf";
        Response response = createPostPage.createPostError(accessToken, username, title, titleType);
        assertEquals(401, response.getStatusCode());
    }
    @Test
    void CreatePostUIncorrectUsername (){
        String incorrectUsernameText = "SUBREDDIT_NOTALLOWED";
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        Response response = createPostPage.createPostError(accessToken, "sdsddsd", title, titleType);
        assertEquals(incorrectUsernameText, response.path("json.errors[0][0]"));
    }
    @Test
    void CreatePostNoText (){
        String incorrectUsernameText = "NO_TEXT";
        String title = "";
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        Response response = createPostPage.createPostError(accessToken, username, title, titleType);
        assertEquals(incorrectUsernameText, response.path("json.errors[0][0]"));
    }

    @Test
    void CreatePostNoType (){
        String titleType = "";
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        Response response = createPostPage.createPostError(accessToken, username, title, titleType);
        assertEquals(500, response.getStatusCode());
    }

}
