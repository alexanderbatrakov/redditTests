package tests.api.pages;

import org.junit.jupiter.api.Test;
import tests.api.TestDataApi;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.response;

public class DeletePostPage extends TestDataApi {

    String username = "Alex211621";
    String password = "swimmer88151";
    String clientId = "Du1kpj218PIM_i16bZuoWQ";
    String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";
    CreatePostPage createPostPage = new CreatePostPage();

    @Test
    public void deletePost() {

       given()
                .auth().preemptive().oauth2(generalPage.getAccessToken(username, password, clientId, clientSecret))
                .spec(request)
                .formParam("id", generalPage.createPostAndGetThingId())
                .post("https://oauth.reddit.com/api/del")
                .then()
                .spec(response); 

    }

}
