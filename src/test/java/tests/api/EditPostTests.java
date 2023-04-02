package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.models.CreatePostModelJson;
import tests.api.models.editPostModels.EditPostModel;
import tests.api.userApi.EditPostApi;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.*;
import static tests.api.TestDataApi.password;
import static tests.api.TestDataApi.*;

@Owner("Batrakov")
@Tag("Api")
class EditPostTests {
    EditPostApi editPostApi = new EditPostApi();

    @AfterEach
    void cleanUp() {
        String accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        DELETE_POST_API.deletePost(accessToken, createPostModelJson.getJson().getData().getName());
    }

    @Test
    @DisplayName("Edit post successful test")
    void editPostSuccessfulTest() {
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = CREATE_POST_API.createPost(accessToken, username, title, titleType).extract().as(CreatePostModelJson.class);
        });
        step("Edit post", () -> {
            String thingId = createPostModelJson.getJson().getData().getName();
            editPostModel = editPostApi.editPost(accessToken, thingId, articleText).extract().as(EditPostModel.class);
        });
        step("Check that article test was edited", () -> {
            assertEquals(articleText, editPostModel.getSelftext());
        });
    }

    @Test
    @DisplayName("Edit post with incorrect access token test")
    void editPostIncorrectTokenTest() {
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = CREATE_POST_API.createPost(accessToken, username, title, titleType).extract().as(CreatePostModelJson.class);
        });
        step("Edit post with incorrect access token", () -> {
            String thingId = createPostModelJson.getJson().getData().getName();
            response = editPostApi.editPost(incorrectAccessToken, thingId, articleText).extract().response();
        });
        step("Check response status code", () -> {
            assertEquals(401, response.getStatusCode());
        });
    }

    @Test
    @DisplayName("Edit post with no title test")
    void editPostNoTitleIdTest() {
        String noTitleErorr = "NO_THING_ID";
        String thingId = "";
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = CREATE_POST_API.createPost(accessToken, username, title, titleType).extract().as(CreatePostModelJson.class);
        });
        step("Edit post with no title id", () -> {
            response = editPostApi.editPost(accessToken, thingId, articleText).extract().response();
        });
        step("Check error text", () -> {
            assertEquals(noTitleErorr, response.path("json.errors[0][0]"));
        });
    }
}
