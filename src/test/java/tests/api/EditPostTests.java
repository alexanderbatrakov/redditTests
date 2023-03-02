package tests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tests.api.pages.EditPostPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditPostTests extends TestDataApi{
    EditPostPage editPostPage = new EditPostPage();

    @AfterEach
    void cleanUp() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        deletePostPage.deletePost(accessToken,createPostModelJson.getJson().getData().getName());
    }
    @Test
    void EditPostSuccessfulTest (){
        String text = "Test string";
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        createPostModelJson = createPostPage.createPost(accessToken, username);
        String thingId = createPostModelJson.getJson().getData().getName();
        editPostModel = editPostPage.editPost(accessToken, thingId, text);

        assertEquals(text, editPostModel.getSelftext());
    }
    @Test
    void EditPostIncorrectTokenTest (){
        String text = "Test string";
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        String incorrectAccessToken = "fdggdfgdf";
        createPostModelJson = createPostPage.createPost(accessToken, username);
        String thingId = createPostModelJson.getJson().getData().getName();
        Response response = editPostPage.editPostError(incorrectAccessToken, thingId, text);

        assertEquals(401, response.getStatusCode());
    }
    @Test
    void EditPostNoTitleIdTest (){
        String text = "Test string";
        String noTitleErorr = "NO_THING_ID";
        String thingId = "";
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        createPostModelJson = createPostPage.createPost(accessToken, username);
        Response response = editPostPage.editPostError(accessToken, thingId, text);

        assertEquals(noTitleErorr, response.path("json.errors[0][0]"));
    }
}
