package tests.api.userApi;

import io.restassured.response.ValidatableResponse;
import tests.api.TestDataApi;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.responseSpec;

public class EditPostApi extends TestDataApi {
    public ValidatableResponse editPost(String accessToken, String id, String text) {

        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("api_type", "json")
                .formParam("thing_id", id)
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\""+text+"\"}]}]}")
                .post("/editusertext")
                .then()
                .spec(responseSpec);
    }

}
