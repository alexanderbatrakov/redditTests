package tests.api.pages;

import io.restassured.response.Response;
import tests.api.TestDataApi;
import tests.api.models.editPostModels.EditPostModel;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.response;

public class EditPostPage extends TestDataApi {
    public EditPostModel editPost(String accessToken, String id, String text) {

        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("api_type", "json")
                .formParam("thing_id", id)
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\""+text+"\"}]}]}")
                .post("https://oauth.reddit.com/api/editusertext")
                .then()
                .spec(response)
                .extract().as(EditPostModel.class);
    }
    public Response editPostError(String accessToken, String id, String text) {

        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("api_type", "json")
                .formParam("thing_id", id)
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\""+text+"\"}]}]}")
                .post("https://oauth.reddit.com/api/editusertext")
                .then()
                .log().body()
                .extract().response();
    }

}
