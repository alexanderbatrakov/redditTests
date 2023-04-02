package tests.api.userApi;

import io.restassured.response.ValidatableResponse;
import tests.api.TestDataApi;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.responseSpec;

public class CreatePostApi extends TestDataApi {
    public ValidatableResponse createPost(String accessToken, String username, String title, String kind) {
        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("sr", "u_" + username.toLowerCase())
                .formParam("api_type", "json")
                .formParam("title", title)
                .formParam("kind", kind)
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\"Test body\"}]}]}")
                .when()
                .post("/submit")
                .then()
                .spec(responseSpec);

    }

}
