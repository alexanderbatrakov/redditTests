package tests.api.pages;

import io.restassured.response.Response;
import tests.api.TestDataApi;
import tests.api.models.CreatePostModelJson;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.response;

public class CreatePostPage extends TestDataApi {

    String username = "Alex211621";
    String password = "swimmer88151";
    String clientId = "Du1kpj218PIM_i16bZuoWQ";
    String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";


    public CreatePostModelJson createPost(String accessToken, String username) {
        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("sr", "u_" + username.toLowerCase())
                .formParam("api_type", "json")
                .formParam("title", "Test title")
                .formParam("kind", "self")
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\"Test body\"}]}]}")
                .post("https://oauth.reddit.com/api/submit")
                .then()
                .spec(response)
                .extract().as(CreatePostModelJson.class);

    }
    public Response createPostError(String accessToken, String username, String title, String kind) {
        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("sr", "u_" + username.toLowerCase())
                .formParam("api_type", "json")
                .formParam("title", title)
                .formParam("kind", kind)
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\"The authorization header will be automatically generated when you send the request. Learn more about authorization\"}]}]}")
                .post("https://oauth.reddit.com/api/submit")
                .then()
                .log().body()
                .extract().response();
    }
}
