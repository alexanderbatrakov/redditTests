package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.incorrectAccessToken;

public class DeletePostTests extends TestDataApi {
    @AfterEach
    void cleanUp() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        deletePostPage.deletePost(accessToken,createPostModelJson.getJson().getData().getName());
    }
    @Test
    @Owner("Batrakov")
    @Tag("Api")
    @DisplayName("Delete post successful test")
    void deletePostSuccessfulTest() {
        step("Get access token", () -> {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
        createPostModelJson = createPostPage.createPost(accessToken, username);
        });
        step("Delete post", () -> {
        String thingId = createPostModelJson.getJson().getData().getName();
        response = deletePostPage.deletePost(accessToken, thingId);
        });
        step("Check response status code", () -> {
        assertEquals(200, response.getStatusCode());
        });
    }

    @Test
    @Owner("Batrakov")
    @Tag("Api")
    @DisplayName("Delete post with incorrect access token test")
    void deleteIncorrectTokenTest() {
        step("Get access token", () -> {
        accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
        createPostModelJson = createPostPage.createPost(accessToken, username);
        });
        step("Delete post with incorrect access token", () -> {
        String thingId = createPostModelJson.getJson().getData().getName();
        response = deletePostPage.deletePost(incorrectAccessToken, thingId);
        });
        step("Check response status code", () -> {
        assertEquals(401, response.getStatusCode());
        });
    }
}
