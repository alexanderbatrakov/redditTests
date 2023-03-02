package tests.api.pages;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.api.TestDataApi;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;

public class DeletePostPage extends TestDataApi {

    String username = "Alex211621";
    String password = "swimmer88151";
    String clientId = "Du1kpj218PIM_i16bZuoWQ";
    String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";
    CreatePostPage createPostPage = new CreatePostPage();

    @Test
    public Response deletePost(String accessToken, String id) {
        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("id", id)
                .post("https://oauth.reddit.com/api/del")
                .then()
                .log().body()
                .extract().response();
    }
}
