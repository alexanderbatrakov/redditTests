package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.models.CreatePostModelJson;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.*;
import static tests.api.TestDataApi.*;
import static tests.api.TestDataApi.password;

@Owner("Batrakov")
@Tag("Api")
class DeletePostTests {
    @AfterEach
    void cleanUp() {
        String accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        DELETE_POST_API.deletePost(accessToken, createPostModelJson.getJson().getData().getName());
    }

    @Test
    @DisplayName("Delete post successful test")
    void deletePostSuccessfulTest() {
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = CREATE_POST_API.createPost(accessToken, username, title, titleType).extract().as(CreatePostModelJson.class);
        });
        step("Delete post", () -> {
            String thingId = createPostModelJson.getJson().getData().getName();
            response = DELETE_POST_API.deletePost(accessToken, thingId);
        });
        step("Check response status code", () -> {
            assertEquals(200, response.getStatusCode());
        });
    }

    @Test
    @DisplayName("Delete post with incorrect access token test")
    void deleteIncorrectTokenTest() {
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = CREATE_POST_API.createPost(accessToken, username, title, titleType).extract().as(CreatePostModelJson.class);
        });
        step("Delete post with incorrect access token", () -> {
            String thingId = createPostModelJson.getJson().getData().getName();
            response = DELETE_POST_API.deletePost(incorrectAccessToken, thingId);
        });
        step("Check response status code", () -> {
            assertEquals(401, response.getStatusCode());
        });
    }
}
