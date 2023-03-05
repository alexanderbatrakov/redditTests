package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.pages.CreatePostPage;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.*;
@Owner("Batrakov")
@Tag("Api")
class CreatePostTests extends TestDataApi {
    CreatePostPage createPostPage = new CreatePostPage();

    @AfterAll
    static void cleanUp() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        deletePostPage.deletePost(accessToken, createPostModelJson.getJson().getData().getName());
    }

    @Test
    @DisplayName("Create post successful test")
    void CreatePostSuccessfulTest() {
        step("Get access token", () -> {
            accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
            createPostModelJson = createPostPage.createPost(accessToken, username);
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
    void CreatePostIncorrectTokenTest() {
        step("Create post with incorrect access token", () -> {
            response = createPostPage.createPostError(incorrectAccessToken, username, title, titleType);
        });
        step("Check response status code", () -> {
            assertEquals(401, response.getStatusCode());
        });
    }

    @Test
    @DisplayName("Create post with incorrect username")
    void CreatePostIncorrectUsername() {
        String incorrectUsernameError = "SUBREDDIT_NOEXIST";
        step("Get access token", () -> {
            accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post with incorrect username", () -> {
            response = createPostPage.createPostError(accessToken, incorrectUsername, title, titleType);
        });
        step("Check error text", () -> {
            assertEquals(incorrectUsernameError, response.path("json.errors[0][0]"));
        });
    }

    @Test
    @DisplayName("Create post with no text")
    void CreatePostNoText() {
        String noTextError = "NO_TEXT";
        String noTitle = "";
        step("Get access token", () -> {
            accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post with no text", () -> {
            response = createPostPage.createPostError(accessToken, username, noTitle, titleType);
        });
        step("Check error text", () -> {
            assertEquals(noTextError, response.path("json.errors[0][0]"));
        });
    }

    @Test
    @DisplayName("Create post with no type")
    void CreatePostNoType() {
        String noTitleType = "";
        step("Get access token", () -> {
            accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post with no type", () -> {
            response = createPostPage.createPostError(accessToken, username, title, noTitleType);
        });
        step("Check response status code", () -> {
            assertEquals(500, response.getStatusCode());
        });
    }

}
