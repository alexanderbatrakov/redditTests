package tests.api.pages;

import org.junit.jupiter.api.Test;
import tests.api.TestDataApi;
import tests.api.models.editPostModels.EditPostModel;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.response;

public class EditPostPage extends TestDataApi {

    String username = "Alex211621";
    String password = "swimmer88151";
    String clientId = "Du1kpj218PIM_i16bZuoWQ";
    String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";
    CreatePostPage createPostPage = new CreatePostPage();

    @Test
    public void editPost() {
        String text = "Test text";
        EditPostModel editPostModel = given()
                .auth().preemptive().oauth2(generalPage.getAccessToken(username, password, clientId, clientSecret))
                .spec(request)
                .formParam("api_type", "json")
                .formParam("thing_id", generalPage.createPostAndGetThingId())
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\""+text+"\"}]}]}")
                .post("https://oauth.reddit.com/api/editusertext")
                .then()
                .spec(response)
                .extract().as(EditPostModel.class);
        assertEquals(text, editPostModel.getSelftext());
    }

}
