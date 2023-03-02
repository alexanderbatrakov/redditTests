package tests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePostTests extends TestDataApi {
    @AfterEach
    void cleanUp() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        deletePostPage.deletePost(accessToken,createPostModelJson.getJson().getData().getName());
    }
    @Test
    void deletePostSuccessfulTest() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        createPostModelJson = createPostPage.createPost(accessToken, username);
        String thingId = createPostModelJson.getJson().getData().getName();
        Response response = deletePostPage.deletePost(accessToken, thingId);

        assertEquals(200, response.getStatusCode());
    }

    @Test
    void deleteIncorrectTokenTest() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        String incorrectAccessToken = "fdggdfgdf";
        createPostModelJson = createPostPage.createPost(accessToken, username);
        String thingId = createPostModelJson.getJson().getData().getName();
        Response response = deletePostPage.deletePost(incorrectAccessToken, thingId);
        assertEquals(401, response.getStatusCode());
    }
}
