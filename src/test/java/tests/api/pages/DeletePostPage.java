package tests.api.pages;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.api.TestDataApi;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;

public class DeletePostPage extends TestDataApi {

    @Test
    public Response deletePost(String accessToken, String id) {
        return given()
                .auth().preemptive().oauth2(accessToken)
                .spec(request)
                .formParam("id", id)
                .post("/del")
                .then()
                .log().body()
                .extract().response();
    }
}
