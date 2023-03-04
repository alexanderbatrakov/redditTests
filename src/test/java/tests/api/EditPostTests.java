package tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.pages.EditPostPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestData.articleText;
import static tests.TestData.incorrectAccessToken;

public class EditPostTests extends TestDataApi{
    EditPostPage editPostPage = new EditPostPage();

    @AfterEach
    void cleanUp() {
        String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        deletePostPage.deletePost(accessToken,createPostModelJson.getJson().getData().getName());
    }
    @Test
    @Owner("Batrakov")
    @Tag("Api")
    @DisplayName("Edit post successful test")
    void EditPostSuccessfulTest (){
        step("Get access token", () -> {
        accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
        createPostModelJson = createPostPage.createPost(accessToken, username);
        });
        step("Edit post", () -> {
        String thingId = createPostModelJson.getJson().getData().getName();
        editPostModel = editPostPage.editPost(accessToken, thingId, articleText);
        });
        step("Check that article test was edited", () -> {
        assertEquals(articleText, editPostModel.getSelftext());
        });
    }
    @Test
    @Owner("Batrakov")
    @Tag("Api")
    @DisplayName("Delete post with incorrect access token test")
    void EditPostIncorrectTokenTest (){
        step("Get access token", () -> {
        accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
        createPostModelJson = createPostPage.createPost(accessToken, username);
        });
        step("Edit post with incorrect access token", () -> {
        String thingId = createPostModelJson.getJson().getData().getName();
        response = editPostPage.editPostError(incorrectAccessToken, thingId, articleText);
        });
        step("Check response status code", () -> {
        assertEquals(401, response.getStatusCode());
        });
    }
    @Test
    @Owner("Batrakov")
    @Tag("Api")
    @DisplayName("Delete post with incorrect access token")
    void EditPostNoTitleIdTest (){
        String noTitleErorr = "NO_THING_ID";
        String thingId = "";
        step("Get access token", () -> {
        accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
        });
        step("Create post", () -> {
        createPostModelJson = createPostPage.createPost(accessToken, username);
        });
        step("Edit post with no title id", () -> {
        response = editPostPage.editPostError(accessToken, thingId, articleText);
        });
        step("Check error text", () -> {
        assertEquals(noTitleErorr, response.path("json.errors[0][0]"));
        });
    }
}
