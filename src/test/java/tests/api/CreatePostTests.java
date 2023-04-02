package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import tests.api.models.CreatePostModelJson;
import tests.api.userApi.CreatePostApi;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.*;
import static tests.api.TestDataApi.password;
import static tests.api.TestDataApi.*;

@Owner("Batrakov")
@Tag("Api")
class CreatePostTests {
    CreatePostApi createPostApi = new CreatePostApi();

    @AfterAll
    static void cleanUp() {
        String accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        DELETE_POST_API.deletePost(accessToken, createPostModelJson.getJson().getData().getName());
    }

    @Test
    @DisplayName("Create post successful test")
    void createPostSuccessfulTest() {
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = createPostApi.createPost(accessToken, username, title, titleType).extract().as(CreatePostModelJson.class);
        });
        step("Check that Url field is not empty", () -> {
            assertThat(createPostModelJson.getJson().getData().getUrl()).isNotEmpty();
        });
        step("Check that Id field is not empty", () -> {
            assertThat(createPostModelJson.getJson().getData().getId()).isNotEmpty();
        });
        step("Check that Name field is not empty", () -> {
            assertThat(createPostModelJson.getJson().getData().getName()).isNotEmpty();
        });
    }

    @Test
    @DisplayName("Create post with incorrect access token test")
    void createPostIncorrectTokenTest() {
        step("Create post with incorrect access token", () -> {
            response = createPostApi.createPost(incorrectAccessToken, username, title, titleType).extract().response();
        });
        step("Check response status code", () -> {
            assertEquals(401, response.getStatusCode());
        });
    }

    @Test
    @DisplayName("Create post with incorrect username")
    void createPostIncorrectUsername() {
        String incorrectUsernameError = "SUBREDDIT_NOEXIST";
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post with incorrect username", () -> {
            response = createPostApi.createPost(accessToken, incorrectUsername, title, titleType).extract().response();
            ;
        });
        step("Check error text", () -> {
            assertEquals(incorrectUsernameError, response.path("json.errors[0][0]"));
        });
    }

    @Test
    @DisplayName("Create post with no text")
    void createPostNoText() {
        String noTextError = "NO_TEXT";
        String noTitle = "";
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post with no text", () -> {
            response = createPostApi.createPost(accessToken, username, noTitle, titleType).extract().response();
            ;
        });
        step("Check error text", () -> {
            assertEquals(noTextError, response.path("json.errors[0][0]"));
        });
    }

    @Test
    @DisplayName("Create post with no type")
    void createPostNoType() {
        String noTitleType = "";
        step("Get access token", () -> {
            accessToken = GENERAL_API.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post with no type", () -> {
            response = createPostApi.createPost(accessToken, username, title, noTitleType).extract().response();
            ;
        });
        step("Check response status code", () -> {
            assertEquals(500, response.getStatusCode());
        });
    }

}
